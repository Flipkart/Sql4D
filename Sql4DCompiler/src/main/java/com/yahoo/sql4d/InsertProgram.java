/**
 * Copyright 2014 Yahoo! Inc. Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License. 
 * See accompanying LICENSE file.
 */
package com.yahoo.sql4d;

import com.yahoo.sql4d.insert.InsertMeta;

/**
 * One or more insert meta.
 * @author srikalyan
 */
public class InsertProgram extends Program<InsertMeta>{
    public boolean waitForCompletion = true;
    public static InsertProgram getInsertInstance() {
        return new InsertProgram(Type.INSERT);
    } 
    
    public static InsertProgram getInsertHadoopInstance() {
        return new InsertProgram(Type.INSERT_HADOOP);
    } 

    public static InsertProgram getInsertRTInstance() {
        return new InsertProgram(Type.INSERT_REALTIME);
    } 

    private InsertProgram(Type type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (InsertMeta iMeta: getAllStmnts()) {
            System.out.println(iMeta.toString());
        }
        return buffer.toString();
    }
    
    /**
     * TODO: Do all semantic checks here. 1st field should be timestamp.
     * @throws java.lang.Exception
     */
    @Override
    public void isValid() throws Exception {
    }

}
