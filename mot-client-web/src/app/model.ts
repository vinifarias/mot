export class DialogDetailsData {
  id_task: number;
  description: string;
  avg_worked_hours: number;
  avg_planned_hours: number;
  constructor() {}
}

export class ProjectTask {
  idTask: number;
  description: string;
  project_description: string;
  planned_hours: number;
  worked_hours: number;
  responsible: string;
  constructor() {}
}

export class Module {
  idModule: number;
  description: string;
  constructor() {}
}

export class Operation {
  idOperation: number;
  idModule: number;
  description: string;
  constructor() {}
}

export class Task {
  IdTask: number;
  idOperation: number;
  description: string;
  constructor() {}
}
