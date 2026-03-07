import { Component, signal } from '@angular/core';
import { Router, NavigationEnd, RouterOutlet } from '@angular/router';
import { Navbar } from './components/navbar/navbar';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar],
  templateUrl: './app.html',
  styleUrl: './app.scss',
})
export class App {
  showNavbar = signal(true);

  private authRoutes = ['crear-perfil', 'home-alarmas', 'crear-alarma'];

  constructor(private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.showNavbar.set(
          !this.authRoutes.some((r) => event.urlAfterRedirects.includes(r))
        );
      }
    });
  }
}
