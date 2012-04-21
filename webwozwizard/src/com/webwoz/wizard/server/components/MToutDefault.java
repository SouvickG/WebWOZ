package com.webwoz.wizard.server.components;

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

import com.webwoz.wizard.server.MToutComp;

public class MToutDefault extends MToutComp {

	private String uttAudioFile;
	private String uttMMFile;
	private String uttText;

	public MToutDefault(int mode) {
		super.setMode(mode);
		super.setName("Off");
	}

	public String getResult(String text) {
		setUttAudio("");
		setUttMM("");
		setUttText(text);
		return getUttText();
	}

	public void setUttAudio(String uttFile) {
		this.uttAudioFile = uttFile;
	}

	public String getUttAudio() {
		return uttAudioFile;
	}

	public void setUttMM(String uttMMFile) {
		this.uttMMFile = uttMMFile;
	}

	public String getUttMM() {
		return uttMMFile;
	}

	public void setUttText(String uttText) {
		this.uttText = uttText;
	}

	public String getUttText() {
		return uttText;
	}
}
