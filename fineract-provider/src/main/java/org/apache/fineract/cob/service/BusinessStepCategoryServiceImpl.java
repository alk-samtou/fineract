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
package org.apache.fineract.cob.service;

import java.util.Map;
import org.apache.fineract.cob.COBBusinessStep;
import org.apache.fineract.cob.loan.LoanCOBBusinessStep;
import org.springframework.stereotype.Service;

@Service
public class BusinessStepCategoryServiceImpl implements BusinessStepCategoryService {

    private final Map<BusinessStepCategory, Class<? extends COBBusinessStep>> businessSteps = Map.of(BusinessStepCategory.LOAN,
            LoanCOBBusinessStep.class);

    @Override
    public Class<? extends COBBusinessStep> getBusinessStepByCategory(String category) {
        Map.Entry<BusinessStepCategory, Class<? extends COBBusinessStep>> businessStepCategoryClassEntry = businessSteps.entrySet().stream()
                .filter(businessStep -> businessStep.getKey().name().equals(category.toUpperCase())).findFirst().orElse(null);
        return businessStepCategoryClassEntry != null ? businessStepCategoryClassEntry.getValue() : null;
    }
}
