/*
 * Copyright (c) 2014 Samsung Electronics Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.samsung.memoryanalysis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.samsung.memoryanalysis.context.ContextProvider;
import com.samsung.memoryanalysis.options.MemoryAnalysisOptions;
import com.samsung.memoryanalysis.referencecounter.ReferenceCounter;
import com.samsung.memoryanalysis.referencecounter.heap.JGraphHeap;
import com.samsung.memoryanalysis.staleness.Staleness;
import com.samsung.memoryanalysis.staleness.StalenessAnalysis;
import com.samsung.memoryanalysis.traceparser.TraceAnalysisRunner;

@RunWith(Parameterized.class)
public class TestStalenessAnalysis extends AbstractTester {

    public final static String pref = "testStaleness";
    public final static String htmlPref = "htmlTest";

    public TestStalenessAnalysis(TestCaseInfo file) {
        super(file);
    }

    @Override
    protected String runAnalysis(File trace) throws Exception {
        StringBuilder r = redirect();
        ReferenceCounter<Staleness> f = new ReferenceCounter<Staleness>(new JGraphHeap(), new StalenessAnalysis());
        // gross.  we want some output even if analysis fails with an assertion
        try {
            Staleness staleness = new TraceAnalysisRunner(new FileInputStream(trace), null, trace.getParentFile()).runAnalysis(new ContextProvider<Staleness>(f, new MemoryAnalysisOptions()));
            staleness.toJSON(System.out, true);
            revert();
            return r.toString();
        } catch (AssertionError e) {
            revert();
            System.out.println(r.toString());
            throw e;
        }
    }

    @Parameterized.Parameters(name="{0}")
    public static Collection<Object[]> data() throws IOException {
        System.setProperty("testing", "yes");
        System.setProperty("rcverbose", "no");
        File dir = new File(TESTDATA);
        List<Object[]> res = new ArrayList<Object[]>();
        addMatchingJS(dir, res, pref);
        addMatchingHTML(dir, res, htmlPref);
        return res;
    }

	@Override
	protected String getExpectedFileName(TestCaseInfo tcInfo) {
		return tcInfo.name + ".staleness.expected";
	}
}
