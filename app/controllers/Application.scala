package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import models.Task

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class Application @Inject() extends Controller {

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    //Ok(views.html.index("Your new application is ready."))
    //Ok(("Your new application is ready."))
    Redirect(routes.Application.tasks)
  }

  def tasks = Action {
    Ok(views.html.index(Task.all(), taskForm))
  }

  def newTask = TODO

  def deleteTask(id: Long) = TODO
}
