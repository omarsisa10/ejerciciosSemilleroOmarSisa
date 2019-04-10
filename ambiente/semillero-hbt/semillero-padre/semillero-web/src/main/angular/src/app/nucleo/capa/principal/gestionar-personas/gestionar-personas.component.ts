import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gestionar-personas',
  templateUrl: './gestionar-personas.component.html'
})
export class GestionarPersonasComponent implements OnInit {
  public header: string = 'Gestionar personas';
  public columnas: string[]= ["nombres","apellidos", "no identificación","tipo identificación","número telefono","edad","estado","acción"];
  constructor() { }

  ngOnInit() {
  }

}
