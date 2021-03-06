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
package com.samsung.memoryanalysis.referencecounter;

import java.util.Set;

import com.samsung.memoryanalysis.context.Context;
import com.samsung.memoryanalysis.traceparser.SourceMap;
import com.samsung.memoryanalysis.traceparser.SourceMap.SourceLocId;
import com.samsung.memoryanalysis.traceparser.Timer;

/**
 * Created by s.jensen on 6/23/14.
 */
public class DummyUnreachabilityAnalysis<T> implements UnreachabilityAwareAnalysis<T> {

	@Override
	public void init(Timer t, SourceMap iidMap) {

	}

	@Override
    public void functionEnter(SourceLocId slId, int funId, SourceLocId callSiteIID, Context newContext, long time) {

    }

    @Override
    public void functionExit(SourceLocId slId, Context functionContext, Set<String> unReferenced, long time) {

    }

    @Override
    public void create(SourceLocId slId, int objectId, long time, boolean isDom) {

    }

    @Override
    public void createFun(SourceLocId slId, int objectId, int prototypeId, SourceLocId functionEnterIID, Set<String> namesReferencedByClosures, Context context, long time) {

    }

    @Override
    public void unreachableObject(SourceLocId slId, int objectId, long time, int shallowSize) {

    }

    @Override
    public void unreachableContext(SourceLocId slId, Context ctx, long time) {

    }

    @Override
    public void lastUse(int objectId, SourceLocId slId, long time) {

    }

    @Override
    public T endExecution(long time) {
        return null;
    }

	@Override
	public void domRoot(int nodeId) {
	}

	@Override
	public void addDOMChild(int parentId, int childId, long time) {
	}

	@Override
	public void removeDOMChild(int parentId, int childId, long time) {
	}

    @Override
    public void putField(SourceLocId slId, int baseId, String offset, int objectId) {

    }

    @Override
    public void write(SourceLocId slId, String name, int objectId) {

    }

    @Override
    public void declare(SourceLocId slId, String name, int objectId) {

    }

    @Override
    public void updateIID(int objId, SourceLocId newIID) {

    }

    @Override
    public void returnStmt(int objId) {

    }

    @Override
    public void debug(SourceLocId slId, int oid) {

    }

	@Override
	public void scriptEnter(SourceLocId slId, String filename) {
	}

	@Override
	public void scriptExit(SourceLocId slId) {
	}

    @Override
    public void topLevelFlush(SourceLocId slId) {
    }

    @Override
    public void addToChildSet(SourceLocId slId, int parentId, String name, int childId) {
    }

    @Override
    public void removeFromChildSet(SourceLocId slId, int parentId, String name, int childId) {
    }

    @Override
    public void endLastUse() {
        // TODO Auto-generated method stub

    }

}
