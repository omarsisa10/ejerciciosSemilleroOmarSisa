import { Component, OnInit } from '@angular/core';
import { personaDTO } from '../apoyo/modelo/personaDTO';

@Component({
  selector: 'app-creacion-personas',
  templateUrl: './creacion-personas.component.html'
})
export class CreacionPersonasComponent implements OnInit {

  public header: string = 'Crear personas';
  public formHidden: boolean = false;
  public persona: personaDTO;
  public editar2: boolean= false;
  fecha= Date.now();


  constructor() { }

  ngOnInit() {
    this.persona = {
      id: '0',
      nombre: '',
      apellido: '',
      tipoIdentificacion: '',
      numeroIdentificacion: '',
      numeroTelefonico: '0',
      fechaNacimiento: 0,
      mayorEdad: true,
      sexo: 'Masculino'
    };
  }
  public editar(){
    this.editar2=false;
  }

}
