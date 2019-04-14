import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreacionPersonasComponent } from './nucleo/capa/principal/creacion-personas/creacion-personas.component'
import { ApoyoComponent } from './nucleo/capa/principal/apoyo/apoyo.component';
import { GestionarPersonasComponent } from './nucleo/capa/principal/gestionar-personas/gestionar-personas.component';
import { EditarPersonasComponent } from './nucleo/capa/principal/editar-personas/editar-personas.component';
import { GestionarVehiculosComponent } from './nucleo/capa/principal/vehiculos/gestionar-vehiculos/gestionar-vehiculos.component';
import { EditarVehiculosComponent } from './nucleo/capa/principal/vehiculos/editar-vehiculos/editar-vehiculos.component';

const routes: Routes = [
	{
		path: 'personas-crear',
		component: CreacionPersonasComponent
	},
	{
		path: 'componente-apoyo',
		component: ApoyoComponent
	},
	{
		path: 'componente-gestionar',
		component: GestionarPersonasComponent
	},
	{
		path: 'personas-editar',
		component: EditarPersonasComponent
	},
	{
		path: 'gestionar-vehiculos',
		component: GestionarVehiculosComponent
	},
	{
		path: 'editar-vehiculos',
		component: EditarVehiculosComponent
	}
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
