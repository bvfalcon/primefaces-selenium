/*
 * Copyright (c) 2011-2021 PrimeFaces Extensions
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package org.primefaces.extensions.selenium.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.primefaces.extensions.selenium.PrimeSelenium;
import org.primefaces.extensions.selenium.component.base.AbstractInputComponent;
import org.primefaces.extensions.selenium.component.base.ComponentUtils;
import org.primefaces.extensions.selenium.findby.FindByParentPartialId;

/**
 * Component wrapper for the PrimeFaces {@code p:rating}.
 */
public abstract class Rating extends AbstractInputComponent {

    @FindByParentPartialId("_input")
    private WebElement input;

    @Override
    public WebElement getInput() {
        return input;
    }

    /**
     * Gets the cancel icon if available.
     *
     * @return the cancel icon
     */
    public WebElement getCancelIcon() {
        return findElement(By.className("ui-rating-cancel"));
    }

    /**
     * Resets the rating so that no stars are selected using the cancel icon.
     */
    public void cancel() {
        WebElement cancelIcon = getCancelIcon();
        if (ComponentUtils.hasBehavior(this, "cancel") || ComponentUtils.hasBehavior(this, "rate")) {
            PrimeSelenium.guardAjax(cancelIcon).click();
        }
        else {
            cancelIcon.click();
        }
    }

    /**
     * Finds the current rating, i.e. the number of stars selected.
     *
     * @return The current rating value.
     */
    public Number getValue() {
        return PrimeSelenium.executeScript("return " + getWidgetByIdScript() + ".getValue();");
    }

    /**
     * Sets the rating to the given value.
     *
     * @param value New rating value to set (number of starts selected).
     */
    public void setValue(Number value) {
        PrimeSelenium.executeScript(getWidgetByIdScript() + ".setValue(" + value + ");");
    }

    /**
     * Enables the rating.
     */
    public void enable() {
        PrimeSelenium.executeScript(getWidgetByIdScript() + ".enable();");
    }

    /**
     * Disables the rating.
     */
    public void disable() {
        PrimeSelenium.executeScript(getWidgetByIdScript() + ".disable();");
    }

    /**
     * Resets the rating so that no stars are selected.
     */
    public void reset() {
        PrimeSelenium.executeScript(getWidgetByIdScript() + ".reset();");
    }

    /**
     * Is this rating disabled?
     *
     * @return true if disabled
     */
    public boolean isDisabled() {
        return PrimeSelenium.executeScript("return " + getWidgetByIdScript() + ".isDisabled();");
    }

    /**
     * Is this rating readonly?
     *
     * @return true if readonly
     */
    public boolean isReadOnly() {
        return PrimeSelenium.executeScript("return " + getWidgetByIdScript() + ".isReadOnly();");
    }

    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }
}