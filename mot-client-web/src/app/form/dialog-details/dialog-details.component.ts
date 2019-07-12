import {Component, Inject, Input, OnInit} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {ProjectTask, DialogDetailsData} from '../../model';
import {DataService} from '../../data.service';

@Component({
  selector: 'app-dialog-details',
  templateUrl: './dialog-details.component.html',
  styleUrls: ['./dialog-details.component.css']
})
export class DialogDetailsComponent implements OnInit {

  dataSource: ProjectTask[];

  displayedColumns = ['projectDescription', 'responsible', 'plannedHours', 'workedHours'];

  constructor(
    public dialogRef: MatDialogRef<DialogDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) public attributes: DialogDetailsData,
    private dataService: DataService) {}

  ngOnInit() {
    this.dataService.get_tasks_projects(this.attributes.description).subscribe((res: any) => {
      this.dataSource = res;
    });
    console.log(this.dataSource);
  }
}
