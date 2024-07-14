case class Book(title: String, author: String, isbn: String)

object practical5_2 {
  var library: Set[Book] = Set(
    Book("Programming in Scala", "Martin Odersky", "9780981531649"),
    Book("Clean Code", "Robert C. Martin", "9780132350884"),
    Book(
      "The Pragmatic Programmer",
      "Andrew Hunt, David Thomas",
      "9780201616224"
    )
  )

  def addBook(book: Book): Unit = {
    library += book
    println(s"Added book: ${book.title} by ${book.author}")
  }

  def removeBook(isbn: String): Unit = {
    library.find(_.isbn == isbn) match {
      case Some(book) =>
        library -= book
        println(s"Removed book: ${book.title}")
      case None =>
        println(s"No book found with ISBN $isbn")
    }
  }

  def containsBook(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach(book =>
      println(s"${book.title} by ${book.author}, ISBN: ${book.isbn}")
    )
  }

  def searchByTitle(title: String): Unit = {
    library.find(_.title.equalsIgnoreCase(title)) match {
      case Some(book) =>
        println(
          s"Book found: ${book.title} by ${book.author}, ISBN: ${book.isbn}"
        )
      case None =>
        println(s"No book found with title '$title'")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach(book =>
        println(s"${book.title}, ISBN: ${book.isbn}")
      )
    } else {
      println(s"No books found by author '$author'")
    }
  }

  def main(args: Array[String]): Unit = {
    displayLibrary()

    println("\nAdding a new book...")
    val newBook = Book(
      "Design Patterns",
      "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
      "9780201633610"
    )
    addBook(newBook)
    displayLibrary()

    println("\nRemoving a book by ISBN...")
    val isbnToRemove = "9780981531649"
    removeBook(isbnToRemove)
    displayLibrary()

    println("\nSearching for a book by title...")
    val titleToSearch = "Clean Code"
    searchByTitle(titleToSearch)

    println("\nDisplaying books by author...")
    val authorToSearch = "Martin Odersky"
    displayBooksByAuthor(authorToSearch)
  }
}
