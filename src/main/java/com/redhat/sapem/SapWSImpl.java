/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.redhat.sapem;

import java.util.logging.Logger;


@javax.jws.WebService(serviceName = "sapWS", portName = "sapWSPort",
                    targetNamespace = "http://service.ws.sample/", 
                    endpointInterface = "com.redhat.sapem.SapWS")
public class SapWSImpl implements SapWS {

    private static final Logger LOG = Logger.getLogger(SapWSImpl.class.getName());


	@Override
	public ProductInfo[] getProductInfo(ProductQuery query) {
		LOG.info("query content:\n" + query);
		ProductInfo [] productInfo = new ProductInfo[query.getProductIds().length];
		for (int i = 0; i < query.getProductIds().length; i++) {
			productInfo[i] = new ProductInfo();
			productInfo[i].setProductId(query.getProductIds()[i]);
			productInfo[i].setArrivalDate(query.getArrivalDate());
			productInfo[i].setDayId("1");
			productInfo[i].setDayOfWeek("Monday");
			productInfo[i].setDescription("AM");
			productInfo[i].setDispatchDate(query.getArrivalDate());
/*			productInfo[i].setEndTime(endTime);
			productInfo[i].setStartTime(startTime);
			productInfo[i].setStartTime(startTime);*/
			productInfo[i].setTsId("1");
			productInfo[i].setType("ATL");
		}
		return productInfo;
	}

}
