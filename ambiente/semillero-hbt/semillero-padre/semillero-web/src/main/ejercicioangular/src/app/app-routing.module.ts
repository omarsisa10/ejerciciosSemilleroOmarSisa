import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CapaComponent } from './nucleo/capa/capa.component';
import { EncabezadoComponent } from './nucleo/capa/encabezado/encabezado.component';
import { MainComponent } from './nucleo/capa/main/main.component';
import { CreacionPersonaComponent } from './nucleo/capa/main/creacion-persona/creacion-persona.component';
import { PiepaginaComponent } from './nucleo/capa/piepagina/piepagina.component';

const routes: Routes = [
{ path: 'capa', component: CapaComponent },
{ path: 'capa/encabezado', component: EncabezadoComponent },
{ path: 'capa/main', component: MainComponent },
{ path: 'capa/main/creapersona', component: CreacionPersonaComponent },
{ path: 'capa/piepagina', component: PiepaginaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
