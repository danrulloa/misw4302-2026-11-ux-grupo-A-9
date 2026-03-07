import { Injectable, signal, computed } from '@angular/core';

export interface Alarma {
  nombre: string;
  hora: string;
  frecuencia: string;
  activa: boolean;
}

@Injectable({ providedIn: 'root' })
export class UserService {
  userName = signal('Tu nombre');
  familyName = signal('Nombre perfil familiar');
  familyRelation = signal('relación contigo');
  hasFamilyProfile = signal(false);

  // 'own' | 'family'
  activeProfile = signal<'own' | 'family'>('own');

  activeProfileName = computed(() =>
    this.activeProfile() === 'own' ? this.userName() : this.familyName()
  );

  activeProfileRelation = computed(() =>
    this.activeProfile() === 'own' ? '(Tu Perfil)' : '(Perfil ' + this.familyRelation() + ')'
  );

  userInitials = computed(() => this.getInitials(this.userName()));
  familyInitials = computed(() => this.getInitials(this.familyName()));

  ownAlarmas = signal<Alarma[]>([]);
  familyAlarmas = signal<Alarma[]>([]);

  activeAlarmas = computed(() =>
    this.activeProfile() === 'own' ? this.ownAlarmas() : this.familyAlarmas()
  );

  addAlarma(alarma: Alarma): void {
    if (this.activeProfile() === 'own') {
      this.ownAlarmas.update(list => [...list, alarma]);
    } else {
      this.familyAlarmas.update(list => [...list, alarma]);
    }
  }

  setReturningUser(): void {
    this.userName.set('Alejandra Mendoza');
    this.ownAlarmas.set([
      { nombre: 'Levotiroxina 50mg', hora: '7:00 AM', frecuencia: 'Todos los días', activa: true },
      { nombre: 'Vitamina D 1000UI', hora: '8:00 AM', frecuencia: 'Todos los días', activa: true },
      { nombre: 'Omeprazol 20mg', hora: '12:00 PM', frecuencia: 'Cada 12 horas', activa: false },
    ]);
  }

  private getInitials(name: string): string {
    const trimmed = name.trim();
    if (!trimmed) return '';
    const words = trimmed.split(/\s+/);
    if (words.length >= 2) {
      return (words[0][0] + words[1][0]).toUpperCase();
    }
    return words[0][0].toUpperCase();
  }
}
