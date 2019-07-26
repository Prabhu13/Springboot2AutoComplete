package com.subhajit.assignment.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Subhajit
 * @since Jul-2019
 * @see com.subhajit.assignment.mode.Node#getChild()
 * @see com.subhajit.assignment.mode.Node#getWords()
 * @see com.subhajit.assignment.mode.Node#toString()
 *
 */
public class Node {
	char data;
	LinkedList<Node> children;
	Node parent;
	boolean isEndOfWord;

	public Node(char c) {
		data = c;
		children = new LinkedList<Node>();
		isEndOfWord = false;
	}

	public Node getChild(char c) {
		if (children != null)
			for (Node eachChild : children)
				if (Character.toLowerCase(eachChild.data) == Character.toLowerCase(c))
					return eachChild;
		return null;
	}

	protected List<String> getWords() {
		List<String> list = new ArrayList<String>();
		if (isEndOfWord) {
			list.add(toString());
		}

		if (children != null) {
			for (int i = 0; i < children.size(); i++) {
				if (children.get(i) != null) {
					list.addAll(children.get(i).getWords());
				}
			}
		}
		return list;
	}

	public String toString() {
		if (parent == null) {
			return "";
		} else {
			return parent.toString() + new String(new char[] { data });
		}
	}
}