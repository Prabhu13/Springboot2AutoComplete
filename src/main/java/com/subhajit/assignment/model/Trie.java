package com.subhajit.assignment.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Subhajit
 * @since Jul-2019
 * @see com.subhajit.assignment.model.Trie#insert
 * @see com.subhajit.assignment.model.Trie#search
 * @see com.subhajit.assignment.model.Trie#autocomplete
 *
 */
public class Trie {
	private Node root;

	public Trie() {
		root = new Node(' ');
	}

	public void insert(String word) {
		if (search(word) == true)
			return;

		Node current = root;
		Node pre;
		for (char ch : word.toCharArray()) {
			pre = current;
			Node child = current.getChild(ch);
			if (child != null) {
				current = child;
				child.parent = pre;
			} else {
				current.children.add(new Node(ch));
				current = current.getChild(ch);
				current.parent = pre;
			}
		}
		current.isEndOfWord = true;
	}

	public boolean search(String word) {
		Node current = root;
		for (char ch : word.toCharArray()) {
			if (current.getChild(ch) == null)
				return false;
			else {
				current = current.getChild(ch);
			}
		}
		if (current.isEndOfWord == true) {
			return true;
		}
		return false;
	}

	public List<String> autocomplete(final String word) {
		Node lastNode = root;
		for (int i = 0; i < word.length(); i++) {
			lastNode = lastNode.getChild(word.charAt(i));
			if (lastNode == null)
				return new ArrayList<String>();
		}
		return lastNode.getWords();
	}
}