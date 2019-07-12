import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class DataService {

  baseUrl = 'https://mot-server.herokuapp.com';

  constructor(private httpClient: HttpClient) {
  }

  get_modules() {
    return this.httpClient.get(this.baseUrl + '/modules/');
  }

  get_operations() {
    return this.httpClient.get(this.baseUrl + '/operations/');
  }

  get_tasks() {
    return this.httpClient.get(this.baseUrl + '/tasks/');
  }

  get_module_operations (moduleDescription: string) {
    return this.httpClient.get(this.baseUrl + '/operations/findByModuleDescription/' + moduleDescription);
  }

  get_operation_tasks (operationDescription: string) {
    return this.httpClient.get(this.baseUrl + '/tasks/findByOperationDescription/' + operationDescription);
  }

  get_tasks_projects (taskDescription: string) {
    return this.httpClient.get(this.baseUrl + '/projectTasks/findProjectTasksByTaskDescription/' + taskDescription);
  }

  get_task_avg_hours (taskDescription: string) {
    return this.httpClient.get(this.baseUrl + '/projectTasks/getAverageHoursByDescription/' + taskDescription);
  }

  get_predicted_hours (taskId: number) {
    return this.httpClient.get(this.baseUrl + '/projectTasks/getPredictedHoursByTaskId/' + taskId);
  }
}
