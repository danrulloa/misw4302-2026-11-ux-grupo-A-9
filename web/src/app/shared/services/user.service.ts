import { Injectable, signal, computed } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class UserService {
  userName = signal('Tu nombre');
  familyName = signal('Nombre perfil familiar');
  familyRelation = signal('relación contigo');

  userInitials = computed(() => this.getInitials(this.userName()));
  familyInitials = computed(() => this.getInitials(this.familyName()));

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
