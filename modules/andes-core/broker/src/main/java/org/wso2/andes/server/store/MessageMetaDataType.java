/*
 * Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.andes.server.store;

import org.wso2.andes.kernel.AndesMessageMetadata;
import org.wso2.andes.server.message.MessageMetaData;
import org.wso2.andes.server.message.MessageMetaData_0_10;

public enum MessageMetaDataType
    /* TODO: Need to remove this class and implement this using the ProtocolType and separate database columns
       for each property instead of handling bytes */
{
    META_DATA_0_91 {   public Factory<MessageMetaData> getFactory() { return MessageMetaData.FACTORY; } },
    META_DATA_0_10 {   public Factory<MessageMetaData_0_10> getFactory() { return MessageMetaData_0_10.FACTORY; } };


    public static interface Factory<M extends StorableMessageMetaData>
    {
        M createMetaData(AndesMessageMetadata messageMetadata);
    }

    abstract public Factory<? extends StorableMessageMetaData> getFactory();

}
