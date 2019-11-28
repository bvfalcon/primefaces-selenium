/**
 * Copyright 2011-2018 PrimeFaces Extensions
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.extensions.selenium.example;

import org.openqa.selenium.support.FindBy;
import org.primefaces.extensions.selenium.AbstractPrimePage;
import org.primefaces.extensions.selenium.component.InputText;
import org.primefaces.extensions.selenium.component.SelectOneMenu;

public class IndexPage extends AbstractPrimePage {
    
    @FindBy(id = "form:manufacturer")
    private SelectOneMenu manufacturer;
    
    @FindBy(id = "form:car")
    private InputText car;

    public SelectOneMenu getManufacturer() {
        return manufacturer;
    }

    public InputText getCar() {
        return car;
    }

    @Override
    public String getLocation() {
        return "index.xhtml";
    }
}