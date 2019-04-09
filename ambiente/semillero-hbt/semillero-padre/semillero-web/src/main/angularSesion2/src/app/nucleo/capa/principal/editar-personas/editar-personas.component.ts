import { Component, OnInit } from '@angular/core';
import { personaDTO } from '../apoyo/modelo/personaDTO';

@Component({
  selector: 'app-editar-personas',
  templateUrl: './editar-personas.component.html',
  styleUrls: ['./editar-personas.component.css']
})
export class EditarPersonasComponent implements OnInit {
  public header: string = 'Editar personas';
  public formHidden: boolean = false;
  public persona: personaDTO;

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

}
