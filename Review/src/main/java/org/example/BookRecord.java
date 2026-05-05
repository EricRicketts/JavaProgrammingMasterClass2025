package org.example;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public record BookRecord(String title, String author, int pages) {

    public BookRecord(String title, String author, int pages) {
        this.title = validateTitleAndReturn(title);
        this.author = validateAuthorAndReturn(author);
        this.pages = validatePagesAndReturn(pages);
    }

    @Override
    @NotNull
    public String toString() {
        return String.format(
                "Title = %s%n" +
                "Author = %s%n" +
                "Number of pages = %s%n", title, author, pages).trim();
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
}
