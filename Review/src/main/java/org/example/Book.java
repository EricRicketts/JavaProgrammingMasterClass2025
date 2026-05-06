package org.example;

import org.jetbrains.annotations.NotNull;

public class Book {

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
                "Number of pages = %s%n", title, author, pages
        ).trim();
    }

    private String validateAuthorAndReturn(String author) {
        String nonNullAuthor = ValueValidator.checkForNullValueAndReturn(
                author,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage()
        );
        String nonEmptyAuthor = ValueValidator.checkForEmptyValueAndReturn(
                nonNullAuthor,
                ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage()
        );
        return ValueValidator.checkForBlankValueAndReturn(
                nonEmptyAuthor,
                ErrorMessages.BLANK_VALUE_MESSAGE_FOR_AUTHOR.getErrorMessage()
        );
    }

    private int validatePagesAndReturn(int pages) {
        return ValueValidator.checkForNegativeValueAndReturn(
                pages,
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_PAGES.getErrorMessage()
        );
    }

    private String validateTitleAndReturn(String title) {
        String nonNullTitle = ValueValidator.checkForNullValueAndReturn(
                title,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_TITLE.getErrorMessage()
        );
        String nonEmptyTitle = ValueValidator.checkForEmptyValueAndReturn(
                nonNullTitle,
                ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_TITLE.getErrorMessage()
        );
        return ValueValidator.checkForBlankValueAndReturn(
                nonEmptyTitle,
                ErrorMessages.BLANK_VALUE_MESSAGE_FOR_TITLE.getErrorMessage()
        );
    }
}
