import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreacionPersonasComponent } from './nucleo/capa/principal/creacion-personas/creacion-personas.component'
import { ApoyoComponent } from './nucleo/capa/principal/apoyo/apoyo.component';
import { GestionarPersonasComponent } from './nucleo/capa/principal/gestionar-personas/gestionar-personas.component';
import { EditarPersonasComponent } from './nucleo/capa/principal/editar-personas/editar-personas.component';

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
	}
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
