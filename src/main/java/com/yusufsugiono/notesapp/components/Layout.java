package com.yusufsugiono.notesapp.components;

import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.BindingConstants;

/**
 * Layout component for pages of application notesapp.
 */
@Import(stylesheet = "context:assets/styles/style.css")
public class Layout
{
    /**
     * The page title, for the <title> element.
     */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;
}
