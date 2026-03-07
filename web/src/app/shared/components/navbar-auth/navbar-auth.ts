import { Component, input, model } from '@angular/core';

@Component({
  selector: 'app-navbar-auth',
  templateUrl: './navbar-auth.html',
  styleUrl: './navbar-auth.scss',
})
export class NavbarAuth {
  userName = input('Nombre');
  userRelation = input('(Relación perfil)');
  tabs = input<string[]>(['Alarmas', 'Historial', 'Perfiles']);
  activeTab = model(2);

  onTabClick(index: number): void {
    this.activeTab.set(index);
  }
}
