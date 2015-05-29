/*
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
package owb;

import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import owb.MyInterface;
import owb.StringBean;

import javax.inject.Inject;

@RunWith(CdiTestRunner.class)
public class GenericsTest
{
    @Inject
    private MyInterface<String> stringBean;

    @Inject
    private MyAbstract<String> stringAbstractBean;

    @Test
    public void injectionTest()
    {
        Assert.assertEquals(StringBean.class.getName(), this.stringBean.getValue());
    }

    @Test
    public void lookupViaBeanClass()
    {
        Assert.assertEquals(StringBean.class.getName(), BeanProvider.getContextualReference(StringBean.class).getValue());
    }

    @Test
    public void lookupViaBeanInterface()
    {
        Assert.assertEquals(StringBean.class.getName(), BeanProvider.getContextualReference(MyInterface.class).getValue());
    }

    @Test
    public void lookupViaBeanAbstractClass()
    {
        Assert.assertEquals(StringBeanAbstract.class.getName(), BeanProvider.getContextualReference(MyAbstract.class).getValue());
    }
}
