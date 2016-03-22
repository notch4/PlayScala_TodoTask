package models

/**
  * Created by yubraj on 3/22/16.
  */
case class Task(id: Int, name: String)

object Task {

  private var taskList: List[Task] = List()

  def all: List[Task] = {taskList}

  def add(taskName: String) = {
    val newId: Int = if(taskList.nonEmpty) taskList.last.id + 1 else 0
    taskList = taskList ++ List(Task(newId, taskName))
  }

  def delete(taskId: Int) = {
    taskList = taskList.filterNot(task => task.id == taskId)
  }
}
