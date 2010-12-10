/*******************************************************************************
 * Open Source Initiative OSI - The MIT License:Licensing
 * The MIT License
 * Copyright (c) 2010 Charles Wagner Jr.
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 ******************************************************************************/
package simpleserver.files;

import java.util.LinkedList;

public class WhitelistLoader extends FileLoader {
	LinkedList<String> users = new LinkedList<String>();
	public WhitelistLoader() {
		this.filename="white-list.txt";
	}
	public boolean isWhitelisted(String name) {
		for (String i: users) {
			if (name.toLowerCase().trim().equals(i.toLowerCase().trim())) {
				return true;
			}
		}
		return false;
	}
	public void addName(String name) {
		users.add(name);
		save();
	}
	public boolean removeName(String name) {
		for (String i: users) {
			if (name.toLowerCase().trim().compareTo(i.toLowerCase().trim())==0) {
				users.remove(i);
				save();
				return true;
			}
		}
		return false;	
	}
	@Override
	protected void beforeLoad() {
		// TODO Auto-generated method stub
		users.clear();
	}
	@Override
	protected void loadLine(String line) {
		// TODO Auto-generated method stub
		users.add(line);
	}
	@Override
	protected String saveString() {
		// TODO Auto-generated method stub
		String line="";
		for (String i: users) {
        	line+=i + "\r\n";
        }
		return line;
	}
}