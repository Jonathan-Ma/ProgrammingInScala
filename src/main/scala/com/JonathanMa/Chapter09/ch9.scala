package com.JonathanMa.Chapter09
import java.io.File


object FileMatcher{
  private val files = new java.io.File(".").listFiles

  def fileEnding(query: String): Array[File] = for (file <- files; if file.getName.endsWith(query))
    yield file

  def fileContains(query: String): Array[File] = for (file <- files; if file.getName.contains(query))
    yield file

  def fileMatch(query: String): Array[File] = for (file <- files; if file.getName.matches(query))
    yield file


}

object FileMatcher2{
  private val files = new File(".").listFiles()

  private def fileMatcher(query: String, method: (String, String) => Boolean): Array[File] = for (file <- files; if method(file.getName, query))
    yield file

  def fileRegex(query: String): Array[File] = fileMatcher(query, _.matches(_))

  def fileContain(query: String): Array[File] = fileMatcher(query, _.contains(_))

  def fileEnds(query: String): Array[File] = fileMatcher(query, _.endsWith(_))
}