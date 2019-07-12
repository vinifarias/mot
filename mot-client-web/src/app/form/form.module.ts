import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormComponent } from './form.component';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDialogModule} from '@angular/material/dialog';
import { DialogDetailsComponent } from './dialog-details/dialog-details.component';
import { MatTableModule } from '@angular/material/table';

@NgModule({
  imports: [
    CommonModule,
    MatSelectModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatSnackBarModule,
    MatDialogModule,
    MatTableModule
  ],
  entryComponents: [
    DialogDetailsComponent
  ],
  exports: [
    FormComponent
  ],
  declarations: [FormComponent, DialogDetailsComponent]
})
export class FormModule { }
