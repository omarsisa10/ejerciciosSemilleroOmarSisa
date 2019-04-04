import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NucleoModule } from './nucleo/nucleo.module';
import { CapaComponent } from './nucleo/capa/capa.component';

@NgModule({
  declarations: [
    AppComponent, AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NucleoModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
