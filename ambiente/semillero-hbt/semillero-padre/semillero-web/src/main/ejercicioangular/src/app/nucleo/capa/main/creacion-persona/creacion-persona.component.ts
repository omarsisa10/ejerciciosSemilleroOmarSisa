import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-creacion-persona',
  templateUrl: './creacion-persona.component.html',
  styleUrls: ['./creacion-persona.component.css']
})
export class CreacionPersonaComponent implements OnInit {
     public id : number;
     public tipoIdentificacion: Array<string> = ['cedula', 'tarjeta', 'pasaporte'];
     public identificacion : number;
     public nombres : string ="OmarSisa";
     public apellidos : string;
  constructor() {
      this.id =0;
      this.identificacion=0;
      this.nombres="";
      this.apellidos="";

  }

  ngOnInit() {
  }


}
