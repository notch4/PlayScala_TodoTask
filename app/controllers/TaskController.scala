package controllers
import models.Task
import play.api.mvc._

/**
  * Created by yubraj on 3/22/16.
  */
object TaskController extends Controller{

  def index = Action{
    Redirect(routes.TaskController.tasks)
  }

  def tasks = Action {
    Ok(views.html.index(Task.all))
  }

  def newTask = Action(parse.urlFormEncoded){
    implicit request =>
      Task.add(request.body.get("tasksName").get.head)
      Redirect(routes.TaskController.index)
  }

  def deleteTasks(id: Int) = Action{
    Task.delete(id)
    Ok
  }

}
