package com.subhajit.assignment.autocomplete;

import java.util.List;

/**
 * @author Subhajit
 *
 */
public interface IAutoComplete {

	List<String> getSuggestion(final String word, final int strength);
}
