import {Component, Input, OnInit} from '@angular/core';
import {DialogDetailsData, ProjectTask} from '../model';
import { FormControl } from '@angular/forms';
import { DataService} from '../data.service';
import { MatDialog, MatSnackBar } from '@angular/material';
import { DialogDetailsComponent } from './dialog-details/dialog-details.component';
import { trigger, state, style, animate, transition } from '@angular/animations';

@Component({
  selector: 'app-search-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
  animations: [
    trigger('enterLeave', [
      state('in', style({transform: 'translateY(0)'})),
      transition('void => *', [
        style({transform: 'translateY(100%)'}),
        animate(100)
      ]),
      transition('* => void', [
        animate(100, style({transform: 'translateY(100%)'}))
      ])
    ])
  ]
})
export class FormComponent implements OnInit {

  @Input() avg_planned_hours: number;
  @Input() avg_worked_hours: number;
  predicted_planned_hours: number;

  @Input() selectedModule: string;
  @Input() selectedOperation: string;
  @Input() selectedTask: ProjectTask;

  @Input() disableOperationSelect = new FormControl(true);
  @Input() disableTaskSelect = new FormControl(true);

  modules: ProjectTask[];
  operations: ProjectTask[];
  tasks: ProjectTask[];

  disableSearchBtn: boolean;

  constructor(
    private dataService: DataService,
    private snackBar: MatSnackBar,
    public dialogTaskDetails: MatDialog
  ) {
    this.disableSearchBtn = true;
  }

  ngOnInit() {
    this.dataService.get_modules().subscribe((res: ProjectTask[]) => {
      this.modules = res;
    });
  }

  changeOperationSelect() {
    if (this.selectedModule !== undefined) {
      this.dataService.get_module_operations(this.selectedModule).subscribe((res: ProjectTask[]) => {
        this.operations = res;
      });
      this.disableOperationSelect.setValue(false);
    } else {
      this.selectedOperation = undefined;
      this.disableOperationSelect.setValue(true);
    }
  }

  changeTaskSelect() {
    if (this.selectedOperation !== undefined && this.selectedModule !== undefined) {
      this.dataService.get_operation_tasks(this.selectedOperation).subscribe((res: ProjectTask[]) => {
        this.tasks = res;
      });
      this.disableTaskSelect.setValue(false);
    } else {
      this.selectedTask.description = undefined;
      this.disableTaskSelect.setValue(true);
    }
  }

  changeDisabledSearchBtn() {
    if (this.selectedTask === null) {
      this.disableSearchBtn = true;
    } else {
      this.disableSearchBtn = false;
    }
    this.realoadHoursTaskInfo();
  }

  getPredictedPlannedHours() {
    this.dataService.get_predicted_hours(this.selectedTask.idTask).subscribe((res: number) => {

      if (res === null) {
        this.snackBar.open('No hours recorded for this task', '', {
          duration: 3000
        });
      } else {
        this.predicted_planned_hours = parseFloat(res.toFixed(2));

      }
    });
  }

  getTaskAvgHours() {
    this.dataService.get_task_avg_hours(this.selectedTask.description).subscribe((res: DialogDetailsData) => {
      // Gets average hours worked
      this.avg_worked_hours = parseFloat(res.avg_worked_hours.toFixed(2));

      // Gets average hours planned
      this.avg_planned_hours = parseFloat(res.avg_planned_hours.toFixed(2));

      console.log(this.avg_worked_hours + ' ' + this.avg_worked_hours);

      if (this.avg_worked_hours === null && this.avg_planned_hours === null) {
        this.snackBar.open('No hours recorded for this task', '', {
          duration: 3000
        });
      }
    });
  }

  realoadHoursTaskInfo() {
    this.predicted_planned_hours = null;
  }

  openDialogTaskDetails() {
    this.dialogTaskDetails.open(DialogDetailsComponent, {
      data: {description: this.selectedTask.description, id_task: this.selectedTask.idTask}
    });
  }
}
