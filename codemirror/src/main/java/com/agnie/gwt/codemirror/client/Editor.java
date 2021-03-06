/*******************************************************************************
 * MIT License (MIT) © 2014 Copyright Agnie Media Software Pvt. Ltd.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package com.agnie.gwt.codemirror.client;

import com.agnie.gwt.codemirror.addon.resources.Cursor;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.TextAreaElement;

/**
 * @author Pandurang Patil 11-Sep-2014
 *
 */
public class Editor extends JavaScriptObject {

	protected Editor() {

	}

	public static native Editor fromTextArea(TextAreaElement editor, Configuration configuration, CodeMirror cmw)
	/*-{
	 	cm = $wnd.CodeMirror.fromTextArea(editor, configuration);
	 	cm.on("focus", function(cminst){
			cmw.@com.agnie.gwt.codemirror.client.CodeMirror::onFocus(Lcom/google/gwt/core/client/JavaScriptObject;)(cminst);
		});
		cm.on("blur", function(){
			cmw.@com.agnie.gwt.codemirror.client.CodeMirror::onBlur()();
		});
		return cm;
		
	}-*/;

	/**
	 * Retrieve contained Document object.
	 * 
	 * @return
	 */
	public final native EditorDocument getDocument()
	/*-{
		return this.doc;
	}-*/;

	public final native void refresh()
	/*-{
	 	this.refresh();
	}-*/;

	public final native void setSize(String width, String height)
	/*-{
		this.setSize( width, height );
	}-*/;

	public final void formatAllContent() {
		Cursor from = (Cursor) Cursor.createObject();
		from.setLine(0);
		from.setCharacterPosition(0);
		Cursor to = (Cursor) Cursor.createObject();
		to.setLine(getDocument().lineCount());
		autoFormatRange(from, to);
	}

	public final native void autoFormatRange(Cursor from, Cursor to)
	/*-{
		this.autoFormatRange( from, to );
	}-*/;
}
