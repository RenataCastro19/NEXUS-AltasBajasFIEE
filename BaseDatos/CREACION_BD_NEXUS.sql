CREATE TABLE Usuario(
	IdUsuario SERIAL PRIMARY KEY,
	NombreUsuario VARCHAR(100) NOT NULL,
	MatriculaUsuario VARCHAR(9) NOT NULL UNIQUE,
	CorreoInstitucional VARCHAR(100) UNIQUE
);

CREATE TABLE Rol(
	IdRol SERIAL PRIMARY KEY,
	NombreRol VARCHAR(20) NOT NULL UNIQUE CHECK (NombreRol IN ('SECRETARIO', 'PROFESOR'))
);

CREATE TABLE UsuarioRol(
	IdUsuarioRol SERIAL PRIMARY KEY,
	IdUsuario INTEGER NOT NULL,
	IdRol INTEGER NOT NULL,
	FOREIGN KEY (IdUsuario) REFERENCES Usuario(IdUsuario),
	FOREIGN KEY (IdRol) REFERENCES Rol(IdRol),
	UNIQUE (IdUsuario, IdRol)
);

CREATE TABLE Periodo(
	IdPeriodo SERIAL PRIMARY KEY,
	NombrePeriodo VARCHAR(100) NOT NULL,
	FechaInicio DATE NOT NULL,
	FechaFin DATE NOT NULL
);

CREATE TABLE ProgramaEducativo(
	IdProgramaEducativo SERIAL PRIMARY KEY,
	NombreProgramaEducativo VARCHAR(100) NOT NULL
);

CREATE TABLE AreaFormacion(
	IdAreaFormacion SERIAL PRIMARY KEY,
	NombreAreaFormacion VARCHAR(100) NOT NULL
);

CREATE TABLE TipoBloqueCreditos(
	IdTipoBloque SERIAL PRIMARY KEY,
	NombreBloqueCreditos VARCHAR(100) NOT NULL,
	CreditosMin INTEGER,
	CreditosMax INTEGER
);

CREATE TABLE ExperienciaEducativa(
	IdEE SERIAL PRIMARY KEY,
	NombreEE VARCHAR(150) NOT NULL,
	IdAreaFormacion INTEGER NOT NULL,
	FOREIGN KEY (IdAreaFormacion) REFERENCES AreaFormacion(IdAreaFormacion)
);

CREATE TABLE Alumno(
	IdAlumno SERIAL PRIMARY KEY,
	matriculaAlumno VARCHAR(9) UNIQUE NOT NULL,
	NombreAlumno VARCHAR(200) NOT NULL,
	CorreoInstitucional VARCHAR(50) UNIQUE NOT NULL,
	IdProgramaEducativo INTEGER NOT NULL,
	FOREIGN KEY (IdProgramaEducativo) REFERENCES ProgramaEducativo(IdProgramaEducativo)
);

CREATE TABLE ProgramaEducativoEE(
	IdProgramaEducativoEE SERIAL PRIMARY KEY,
	IdProgramaEducativo INTEGER NOT NULL,
	IdEE INTEGER NOT NULL,
	Creditos INTEGER NOT NULL,
	FOREIGN KEY (IdProgramaEducativo) REFERENCES ProgramaEducativo(IdProgramaEducativo),
	FOREIGN KEY (IdEE) REFERENCES ExperienciaEducativa(IdEE),
	UNIQUE (IdProgramaEducativo, IdEE)
);

CREATE TABLE Prerrequisito(
	IdPrerrequisito SERIAL PRIMARY KEY,
	IdProgramaEducativo INTEGER NOT NULL,
	IdEE INTEGER NOT NULL,
	IdEEPrerrequisito INTEGER NOT NULL,
	FOREIGN KEY (IdProgramaEducativo) REFERENCES ProgramaEducativo(IdProgramaEducativo),
	FOREIGN KEY (IdEE) REFERENCES ExperienciaEducativa(IdEE),
	FOREIGN KEY (IdEEPrerrequisito) REFERENCES ExperienciaEducativa(IdEE),
	CHECK (IdEE <> IdEEPrerrequisito),
	UNIQUE (IdProgramaEducativo, IdEE, IdEEPrerrequisito)
);

CREATE TABLE Grupo(
	IdGrupo SERIAL PRIMARY KEY,
	IdEE INTEGER NOT NULL,
	IdPeriodo INTEGER NOT NULL,
	IdProfesor INTEGER NOT NULL,
	CupoMax INTEGER NOT NULL,
	NRC VARCHAR(5) NOT NULL,
	SALON VARCHAR(10) NOT NULL,
	FOREIGN KEY (IdEE) REFERENCES ExperienciaEducativa(IdEE),
	FOREIGN KEY (IdPeriodo) REFERENCES Periodo(IdPeriodo),
	FOREIGN KEY (IdProfesor) REFERENCES Usuario(IdUsuario),
	UNIQUE (IdPeriodo, NRC)
);

CREATE TABLE GrupoProgramaEducativo(
	IdGrupoProgramaEducativo SERIAL PRIMARY KEY,
	IdGrupo INTEGER NOT NULL,
	IdProgramaEducativo INTEGER NOT NULL,
	FOREIGN KEY (IdGrupo) REFERENCES Grupo(IdGrupo),
	FOREIGN KEY (IdProgramaEducativo) REFERENCES ProgramaEducativo(IdProgramaEducativo),
	UNIQUE (IdGrupo, IdProgramaEducativo)
);

CREATE TABLE BloqueHorario(
	IdBloqueHorario SERIAL PRIMARY KEY,
	IdGrupo INTEGER NOT NULL,
	Dia VARCHAR(10) NOT NULL CHECK (Dia IN ('LUNES', 'MARTES', 'MIERCOLES', 'JUEVES', 'VIERNES')),
	HoraInicio TIME NOT NULL,
	HoraFin TIME NOT NULL,
	FOREIGN KEY (IdGrupo) REFERENCES Grupo(IdGrupo),
	CHECK (HoraFin > HoraInicio)
);

CREATE TABLE Inscripcion(
	IdInscripcion SERIAL PRIMARY KEY,
	IdAlumno INTEGER NOT NULL,
	IdGrupo INTEGER NOT NULL,
	Estado VARCHAR(15) NOT NULL CHECK (Estado IN ('CURSANDO', 'APROBADA', 'REPROBADA', 'BAJA')),
	FOREIGN KEY (IdAlumno) REFERENCES Alumno(IdAlumno),
	FOREIGN KEY (IdGrupo) REFERENCES Grupo(IdGrupo),
	UNIQUE (IdAlumno, IdGrupo)
);

CREATE TABLE HabilitadoBloque(
	IdHabilitadoBloque SERIAL PRIMARY KEY,
	IdPeriodo INTEGER NOT NULL,
	IdTipoBloque INTEGER NOT NULL,
	FechaInicio DATE NOT NULL,
	FechaFin DATE NOT NULL,
	HoraLimite TIME NOT NULL,
	FOREIGN KEY (IdPeriodo) REFERENCES Periodo(IdPeriodo),
	FOREIGN KEY (IdTipoBloque) REFERENCES TipoBloqueCreditos(IdTipoBloque),
	UNIQUE (IdPeriodo, IdTipoBloque)
);

CREATE TABLE SolicitudTramite(
	IdSolicitudTramite SERIAL PRIMARY KEY,
	IdPeriodo INTEGER NOT NULL,
	IdAlumno INTEGER NOT NULL,
	FechaSolicitud DATE NOT NULL,
	FOREIGN KEY (IdPeriodo) REFERENCES Periodo(IdPeriodo),
	FOREIGN KEY (IdAlumno) REFERENCES Alumno(IdAlumno)
);

CREATE TABLE SolicitudDetalle(
	IdSolicitudDetalle SERIAL PRIMARY KEY,
	IdSolicitudTramite INTEGER NOT NULL,
	IdGrupo INTEGER NOT NULL,
	IdSecretario INTEGER,
	TipoSolicitud VARCHAR(10) NOT NULL CHECK (TipoSolicitud IN ('ALTA', 'BAJA')),
	Estado VARCHAR(15) NOT NULL CHECK (Estado IN ('PENDIENTE', 'RECHAZADA', 'ACEPTADA')),
	FechaSolucion DATE,
	FOREIGN KEY (IdSolicitudTramite) REFERENCES SolicitudTramite(IdSolicitudTramite),
	FOREIGN KEY (IdGrupo) REFERENCES Grupo(IdGrupo),
	FOREIGN KEY (IdSecretario) REFERENCES Usuario(IdUsuario)
);

CREATE TABLE Notificacion(
	IdNotificacion SERIAL PRIMARY KEY,
	IdAlumno INTEGER NOT NULL,
	IdSolicitudDetalle INTEGER,
	Canal VARCHAR(10) NOT NULL CHECK (Canal IN ('CORREO', 'APP')),
	FechaEnvio DATE NOT NULL,
	Mensaje VARCHAR(400) NOT NULL,
	FOREIGN KEY (IdAlumno) REFERENCES Alumno(IdAlumno),
	FOREIGN KEY (IdSolicitudDetalle) REFERENCES SolicitudDetalle(IdSolicitudDetalle)
);

GRANT USAGE ON SCHEMA public TO nexus_app;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO nexus_app;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO nexus_app;