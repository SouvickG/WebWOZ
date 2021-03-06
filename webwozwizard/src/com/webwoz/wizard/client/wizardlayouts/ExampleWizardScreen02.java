package com.webwoz.wizard.client.wizardlayouts;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.webwoz.wizard.client.Screen;

public class ExampleWizardScreen02 implements Screen {

	// panels
	private VerticalPanel layout = new VerticalPanel();
	private HorizontalPanel horPanel = new HorizontalPanel();
	private VerticalPanel inputA = new VerticalPanel();
	private VerticalPanel buttonsA = new VerticalPanel();
	private VerticalPanel inputB = new VerticalPanel();
	private VerticalPanel buttonsB = new VerticalPanel();
	private VerticalPanel output = new VerticalPanel();

	// labels
	private Label outputHeadingLabel = new Label();
	private Label inputAHeadingLabel = new Label();
	private Label inputBHeadingLabel = new Label();
	private Label buttonsAHeadingLabel = new Label();
	private Label buttonsBHeadingLabel = new Label();

	// buttons
	private Button inputASendButton = new Button("Send >");
	private Button inputBSendButton = new Button("< Send");

	// text boxes/areas
	private TextArea outputText = new TextArea();
	private TextArea inputATextSource = new TextArea();
	private TextArea inputATextTrans = new TextArea();
	private TextArea inputBTextSource = new TextArea();
	private TextArea inputBTextTrans = new TextArea();

	public ExampleWizardScreen02() {

		// format labels
		outputHeadingLabel.setText("Chat Protocol");
		outputHeadingLabel.addStyleName("outputHeader");
		inputAHeadingLabel.setText("Input User A");
		inputAHeadingLabel.addStyleName("inputAHeader");
		inputBHeadingLabel.setText("Input User B");
		inputBHeadingLabel.addStyleName("inputBHeader");
		buttonsAHeadingLabel.setText(":");
		buttonsAHeadingLabel.addStyleName("buttonsAHeader");
		buttonsBHeadingLabel.setText(":");
		buttonsBHeadingLabel.addStyleName("buttonsBHeader");

		// format text boxes/areas
		outputText.setCharacterWidth(30);
		outputText.setVisibleLines(7);
		inputATextSource.setCharacterWidth(30);
		inputATextSource.setVisibleLines(3);
		inputATextTrans.setCharacterWidth(30);
		inputATextTrans.setVisibleLines(3);
		inputBTextSource.setCharacterWidth(30);
		inputBTextSource.setVisibleLines(3);
		inputBTextTrans.setCharacterWidth(30);
		inputBTextTrans.setVisibleLines(3);

		// build layout
		// input A
		inputA.add(inputAHeadingLabel);
		inputA.add(inputATextSource);
		inputA.add(inputATextTrans);
		inputA.addStyleName("inputA");

		// buttons A
		buttonsA.addStyleName("buttonsA");
		buttonsA.add(inputASendButton);

		// output box
		output.addStyleName("output");
		output.add(outputHeadingLabel);
		output.add(outputText);

		// buttons B
		buttonsB.addStyleName("buttonsB");
		buttonsB.add(inputBSendButton);

		// input B
		inputB.add(inputBHeadingLabel);
		inputB.add(inputBTextSource);
		inputB.add(inputBTextTrans);
		inputB.addStyleName("inputB");

		// add everything to the horPanel and format it
		horPanel.add(inputA);
		horPanel.add(buttonsA);
		horPanel.add(output);
		horPanel.add(buttonsB);
		horPanel.add(inputB);

		// add to layout
		layout.add(horPanel);

	}

	public VerticalPanel getScreen() {
		return layout;
	}

	public void stopReload() {

	}

	public void turnOffComponent() {

	}

	public void changeVisibility() {

	}

}
