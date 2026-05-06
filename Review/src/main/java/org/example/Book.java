package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class Book {

    private final Pattern ONE_OR_MORE_SPACES = Pattern.compile("\\s+");

    private final String EMPTY_STRING = "";

    private final String title, author;

    private final int pages;

    public Book(String title, String author, int pages) {
        this.title = this.validateTitleAndReturn(title);
        this.author = this.validateAuthorAndReturn(author);
        this.pages = this.validatePagesAndReturn(pages);
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPages() {
        return this.pages;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    @NotNull
    public String toString() {
        return String.format(
                "Title = %s%n" +
                "Author = %s%n" +
                "Number of pages = %s%n",
                title,
                author,
                pages
        ).trim();
    }

    private String validateAuthorAndReturn(String author) {
        return switch(author) {
            case null -> throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage()
            );
            case EMPTY_STRING -> throw new IllegalArgumentException(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage()
            );
            case String s when ONE_OR_MORE_SPACES.matcher(s).matches() -> throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage()
            );
            default -> author;
        };
    }

    private int validatePagesAndReturn(int pages) {
        return ValueValidator.checkForNegativeValueAndReturn(
                pages,
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_PAGES.getErrorMessage()
        );
    }

    private String validateTitleAndReturn(String title) {
        return switch(title) {
            case null -> throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_TITLE.getErrorMessage()
            );
            case EMPTY_STRING -> throw new IllegalArgumentException(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_TITLE.getErrorMessage()
            );
            case String s when ONE_OR_MORE_SPACES.matcher(s).matches() -> throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_TITLE.getErrorMessage()
            );
            default -> title;
        };
    }
}
