package org.example;

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
    public String toString() {

        return "Title = " + this.getTitle() + ", " +
                "Author = " + this.getAuthor() + ", " +
                "Number of pages = " + this.getPages();
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
        String message = "Number of pages assigned to book is less than zero";
        return ValueValidator.checkForNegativeValueAndReturn(pages, message);
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
