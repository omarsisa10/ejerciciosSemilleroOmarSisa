import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gestionar-personas',
  templateUrl: './gestionar-personas.component.html'
})
export class GestionarPersonasComponent implements OnInit {
  public header: string = 'Gestionar personas';

  constructor() { }

  ngOnInit() {
  }

}
