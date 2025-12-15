# (Tracks 1 y 3)

Lista de comandos
## 🗂️ Estructura de Archivos
*   `k8s/` -> Archivos del **Track 1** (Sin número de estudiante).
*   `k8s/track3/` -> Archivos del **Track 3** (Con número de estudiante: `maria-12-*`).

---

## 1. Track 1 (FRI) - Revisión Inicial
**Configuración**: `maria-*-*.yml` | **Namespace**: `maria-namespace`

### Despliegue Inicial
```bash
kubectl apply -f k8s/maria-namespace.yml
kubectl apply -f k8s/maria-secret.yml
kubectl apply -f k8s/maria-deployment.yml
kubectl apply -f k8s/maria-service.yml
```

### Reiniciar (Obligatorio si cambias puertos/secretos)
Si editas el `maria-secret.yml` para cambiar el puerto, debes ejecutar:

```bash
# 1. Aplicar cambios
kubectl apply -f k8s/maria-secret.yml
kubectl apply -f k8s/maria-deployment.yml
kubectl apply -f k8s/maria-service.yml

# 2. Reiniciar Pods (Rollout)
kubectl rollout restart deployment/maria-deployment -n maria-namespace

# 3. Verificar
kubectl get pods -n maria-namespace
```

### Acceso (Port-Forward) - Requisito de Evaluación (9094)
Para el **Track 1 (FRI)**, el requerimiento pide un puerto flexible (ej. 9094):

```bash
# Puerto Local 9094 -> Servicio (Puerto 80 que lleva al Port Interno)
kubectl port-forward svc/maria-service 9094:80 -n maria-namespace
```

**URL**: `http://localhost:9094/v1/api/student`

---

## 2. Track 3 (AEJ) - Evaluación Tecnológica
**Configuración**: `maria-12-*.yml` | **Namespace**: `maria-12-namespace`

### Despliegue Inicial
```bash
kubectl apply -f k8s/track3/maria-12-namespace.yml
kubectl apply -f k8s/track3/maria-12-secret.yml
kubectl apply -f k8s/track3/maria-12-deployment.yml
kubectl apply -f k8s/track3/maria-12-service.yml
```

### Reiniciar (Obligatorio si cambias puertos/secretos)
Si editas el `maria-12-secret.yml` para cambiar el puerto a 9090, debes ejecutar:

```bash
# 1. Aplicar cambios
kubectl apply -f k8s/track3/maria-12-secret.yml
kubectl apply -f k8s/track3/maria-12-deployment.yml
kubectl apply -f k8s/track3/maria-12-service.yml

# 2. Reiniciar Pods (Rollout)
kubectl rollout restart deployment/maria-12-deployment -n maria-12-namespace

# 3. Verificar
kubectl get pods -n maria-12-namespace
```

### Acceso (Port-Forward) - Requisito de Evaluación
Para el **Track 3 (AEJ)**, si te piden acceso local por el puerto `8094` o el que definan:

```bash
# Puerto Local 8094 -> Servicio (que apunta al 9090)
kubectl port-forward svc/maria-12-service 8094:80 -n maria-12-namespace
```

**URL**: `http://localhost:8094/v1/api/student`
