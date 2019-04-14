import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gestionar-vehiculos',
  templateUrl: './gestionar-vehiculos.component.html'
})
export class GestionarVehiculosComponent implements OnInit {
  public header: string = 'Gestionar Vehiculos';
  public columnas: string[]= ["Marca","linea", "placa","modelo","color","acción"];
  constructor() { }

  ngOnInit() {
  }

}
