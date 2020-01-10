package Principal;

//IMPORTAMOS LOS PAQUETES NECESARIOS
import BD.*;
import Extractor.ExtraerAlumno;
import Extractor.ExtraerPractica;

import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

//CLASE PRINCIPAL
public final class MenuPrincipal extends javax.swing.JFrame {

    /*el usuario que va a estar trabajando con el sistema*/
    Usuario userPrincipal = new Usuario();
    /*objetos que facilitan el CRUD de Alumnos Y practicas*/
    Alumno Alumno = new Alumno();
    Practica Practica = new Practica();
    /*retorna el codigo de las carreras o de los semestres*/
    codigo Codigo = new codigo();

    /*conexión a la base de datos*/
    BD bd = new BD();

    /**
     * constructor vacio, cuando no se ha logueado ningun usuario
     */
    public MenuPrincipal() {
        initComponents();
        userPrincipal.tipo = 0;
        valores(userPrincipal.tipo);
        Espere.setVisible(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {

            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });

    }

    /**
     * constructor que se usa cuando el usuario ya está logueado y se vita de
     * que lo vuelva a hacer
     *
     * @param id -> recibe el idUsuario con este parametro podemos obtener toda
     * la informacion del usuario
     */
    public MenuPrincipal(int id) {
        initComponents();
        userPrincipal.id = id;//agrega el id

        //obtiene lainformacion 
        userPrincipal.MostrarUsuarioId();
        //otorga los permisos
        valores(userPrincipal.tipo);
        Espere.setVisible(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            //sobreescribe el evento cerrando ventana
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
    }

    private void close() {
        //pregunta si realmente desea salir del sistema
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * otorga los permisos
     *
     * @param a
     */
    public void valores(int a) {
        /**
         * si no se ha logueado
         */
        if (a == 0) {
            this.menuUsuario.setVisible(false);
            this.menuRegistro.setVisible(false);
            this.menuPracticas.setVisible(false);
            this.menuAlumno.setVisible(false);
            this.itemIngresar.setVisible(true);
            this.itemSalir.setVisible(false);
            this.itemCambiarUC.setVisible(false);

        } /**
         * activa todas las funciones
         */
        else {
            this.menuUsuario.setVisible(true);
            this.menuRegistro.setVisible(true);
            this.menuPracticas.setVisible(true);
            this.menuAlumno.setVisible(true);
            this.itemIngresar.setVisible(false);
            this.itemSalir.setVisible(true);
            this.itemCambiarUC.setVisible(true);
        }
        /**
         * si el usuario no es privilegiado desactiva del menu la opcion de
         * crear modificar y eliminar usuarios
         */
        if (a != 1) {
            this.menuUsuario.setVisible(false);
        }
    }

    /**
     * Insertar icono
     *
     * @return
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagen/icono.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JDialog();
        etqLoginL = new javax.swing.JLabel();
        etqUsuarioL = new javax.swing.JLabel();
        etqContraseñaL = new javax.swing.JLabel();
        txtUsuarioL = new javax.swing.JTextField();
        pwdContraseñaL = new javax.swing.JPasswordField();
        btnIngresarL = new javax.swing.JButton();
        btnCancelarL = new javax.swing.JButton();
        alumno = new javax.swing.JDialog();
        etqMatriculaAA = new javax.swing.JLabel();
        etqNombreAA = new javax.swing.JLabel();
        etqGrupoAA = new javax.swing.JLabel();
        etqSemestreAA = new javax.swing.JLabel();
        etqCarreraAA = new javax.swing.JLabel();
        txtMatriculaAlumno = new javax.swing.JTextField();
        txtNombreAlumno = new javax.swing.JTextField();
        cmbSemestreAlumno = new javax.swing.JComboBox<>();
        cmbCarreraAlumno = new javax.swing.JComboBox<>();
        btnAgregarAlumno = new javax.swing.JButton();
        btnCancelarAlumno = new javax.swing.JButton();
        cmbGrupoAlumno = new javax.swing.JComboBox<>();
        btnModificarAlumno = new javax.swing.JButton();
        usuario = new javax.swing.JDialog();
        etqNombreUsuario = new javax.swing.JLabel();
        etqApellidoUsuario = new javax.swing.JLabel();
        etqUsernameUsuario = new javax.swing.JLabel();
        etqPwdUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtApellidosUsuario = new javax.swing.JTextField();
        txtUsernameUsuario = new javax.swing.JTextField();
        pwdContraseñaUsuario = new javax.swing.JPasswordField();
        btnAgregarUsuario = new javax.swing.JButton();
        btnCancelarUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();
        etqIdUsuario = new javax.swing.JLabel();
        MostrarUsuarios = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnCancelarMUsuarios = new javax.swing.JButton();
        practica = new javax.swing.JDialog();
        etqCodigoAP = new javax.swing.JLabel();
        etqNombreAP = new javax.swing.JLabel();
        etqSemestreAP = new javax.swing.JLabel();
        etqCarreraAP = new javax.swing.JLabel();
        txtCodigoPractica = new javax.swing.JTextField();
        txtNombrePractica = new javax.swing.JTextField();
        cmbSemestrePractica = new javax.swing.JComboBox<>();
        cmbCarreraPractica = new javax.swing.JComboBox<>();
        btnAgregarPractica = new javax.swing.JButton();
        btnCancelarPractica = new javax.swing.JButton();
        btnModificarPractica = new javax.swing.JButton();
        misdatos = new javax.swing.JDialog();
        etqUsuarioMD = new javax.swing.JLabel();
        etqContraseñaMD = new javax.swing.JLabel();
        txtNombreMD = new javax.swing.JTextField();
        txtApellidosMD = new javax.swing.JTextField();
        txtUsuarioMD = new javax.swing.JTextField();
        pwdContraseñaMD = new javax.swing.JPasswordField();
        btnAgregarMD = new javax.swing.JButton();
        btnCancelarMD = new javax.swing.JButton();
        etqNombreMD = new javax.swing.JLabel();
        etqApellidoMD = new javax.swing.JLabel();
        EliminarPractica = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPracticas = new javax.swing.JTable();
        Espere = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        itemIngresar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();
        itemCambiarUC = new javax.swing.JMenuItem();
        itemRealizarRegistro = new javax.swing.JMenuItem();
        menuRegistro = new javax.swing.JMenu();
        itemGenerarReporte = new javax.swing.JMenuItem();
        itemHacerConsulta = new javax.swing.JMenuItem();
        itemReporteDiario = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuAlumno = new javax.swing.JMenu();
        itemAgregarListaAlumno = new javax.swing.JMenuItem();
        itemAgregarAlumno = new javax.swing.JMenuItem();
        itemActualizarAlumno = new javax.swing.JMenuItem();
        itemEliminarAlumno = new javax.swing.JMenuItem();
        menuPracticas = new javax.swing.JMenu();
        itemAgregarListaPracticas = new javax.swing.JMenuItem();
        itemAgregarPractica = new javax.swing.JMenuItem();
        itemActualizarPractica = new javax.swing.JMenuItem();
        itemEliminarPracticas = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        itemNuevoUsuario = new javax.swing.JMenuItem();
        itemModificarUsuario = new javax.swing.JMenuItem();
        itemEliminarUsuario = new javax.swing.JMenuItem();

        Login.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Login.setTitle("Login");
        Login.setModal(true);
        Login.setResizable(false);
        Login.setSize(new java.awt.Dimension(369, 203));
        Login.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                LoginWindowClosed(evt);
            }
        });

        etqLoginL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqLoginL.setText("Introduzca nombre de usuario y contraseña.");

        etqUsuarioL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqUsuarioL.setText("Usuario:");

        etqContraseñaL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqContraseñaL.setText("Contraseña:");

        txtUsuarioL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsuarioL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioLKeyPressed(evt);
            }
        });

        pwdContraseñaL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pwdContraseñaL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwdContraseñaLKeyPressed(evt);
            }
        });

        btnIngresarL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnIngresarL.setText("Ingresar");
        btnIngresarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarLActionPerformed(evt);
            }
        });

        btnCancelarL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelarL.setText("Cancelar");
        btnCancelarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login.getContentPane());
        Login.getContentPane().setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etqLoginL))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnIngresarL)
                        .addGap(56, 56, 56)
                        .addComponent(btnCancelarL)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LoginLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(etqUsuarioL)
                        .addComponent(etqContraseñaL))
                    .addGap(26, 26, 26)
                    .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtUsuarioL)
                        .addComponent(pwdContraseñaL, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                    .addContainerGap(60, Short.MAX_VALUE)))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqLoginL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarL)
                    .addComponent(btnCancelarL))
                .addGap(34, 34, 34))
            .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LoginLayout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etqUsuarioL)
                        .addComponent(txtUsuarioL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etqContraseñaL)
                        .addComponent(pwdContraseñaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(81, Short.MAX_VALUE)))
        );

        alumno.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        alumno.setTitle("Agregar alumno");
        alumno.setModal(true);
        alumno.setResizable(false);
        alumno.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                alumnoWindowClosed(evt);
            }
        });

        etqMatriculaAA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqMatriculaAA.setText("Matricula:");

        etqNombreAA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqNombreAA.setText("Nombre completo:");

        etqGrupoAA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqGrupoAA.setText("Grupo:");

        etqSemestreAA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqSemestreAA.setText("Semestre:");

        etqCarreraAA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqCarreraAA.setText("Carrera:");

        txtMatriculaAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMatriculaAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMatriculaAlumnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatriculaAlumnoKeyTyped(evt);
            }
        });

        txtNombreAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombreAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreAlumnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreAlumnoKeyTyped(evt);
            }
        });

        cmbSemestreAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbSemestreAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Septimo", "Octavo", "Noveno", "Decimo" }));
        cmbSemestreAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSemestreAlumnoActionPerformed(evt);
            }
        });

        cmbCarreraAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbCarreraAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enfermería", "Medicina", "Odontología" }));
        cmbCarreraAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCarreraAlumnoActionPerformed(evt);
            }
        });

        btnAgregarAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAgregarAlumno.setText("Agregar");
        btnAgregarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlumnoActionPerformed(evt);
            }
        });

        btnCancelarAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelarAlumno.setText("Cancelar");
        btnCancelarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlumnoActionPerformed(evt);
            }
        });

        cmbGrupoAlumno.setEditable(true);
        cmbGrupoAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbGrupoAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "se mama", "la neta", " " }));
        cmbGrupoAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGrupoAlumnoActionPerformed(evt);
            }
        });

        btnModificarAlumno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificarAlumno.setText("Modificar");

        javax.swing.GroupLayout alumnoLayout = new javax.swing.GroupLayout(alumno.getContentPane());
        alumno.getContentPane().setLayout(alumnoLayout);
        alumnoLayout.setHorizontalGroup(
            alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(alumnoLayout.createSequentialGroup()
                        .addGroup(alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqMatriculaAA)
                            .addComponent(etqNombreAA)
                            .addComponent(etqCarreraAA)
                            .addComponent(etqSemestreAA)
                            .addComponent(etqGrupoAA))
                        .addGap(26, 26, 26)
                        .addGroup(alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbGrupoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCarreraAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSemestreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatriculaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, alumnoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregarAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarAlumno)
                        .addGap(5, 5, 5))))
        );
        alumnoLayout.setVerticalGroup(
            alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqMatriculaAA)
                    .addComponent(txtMatriculaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqNombreAA)
                    .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCarreraAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqCarreraAA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSemestreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqSemestreAA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqGrupoAA)
                    .addComponent(cmbGrupoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(alumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarAlumno)
                    .addComponent(btnCancelarAlumno)
                    .addComponent(btnModificarAlumno))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        usuario.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        usuario.setTitle("Agregar usuario");
        usuario.setModal(true);
        usuario.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                usuarioWindowClosed(evt);
            }
        });

        etqNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqNombreUsuario.setText("Nombre:");

        etqApellidoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqApellidoUsuario.setText("Apellidos:");

        etqUsernameUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqUsernameUsuario.setText("Usuario:");

        etqPwdUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqPwdUsuario.setText("Contraseña:");

        txtNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyTyped(evt);
            }
        });

        txtApellidosUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtApellidosUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosUsuarioKeyTyped(evt);
            }
        });

        txtUsernameUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsernameUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameUsuarioKeyPressed(evt);
            }
        });

        pwdContraseñaUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnAgregarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAgregarUsuario.setText("Agregar");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });

        btnCancelarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelarUsuario.setText("Cancelar");
        btnCancelarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarUsuarioActionPerformed(evt);
            }
        });

        btnModificarUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificarUsuario.setText("Modificar");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout usuarioLayout = new javax.swing.GroupLayout(usuario.getContentPane());
        usuario.getContentPane().setLayout(usuarioLayout);
        usuarioLayout.setHorizontalGroup(
            usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(usuarioLayout.createSequentialGroup()
                        .addGap(0, 23, Short.MAX_VALUE)
                        .addComponent(btnAgregarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarUsuario))
                    .addGroup(usuarioLayout.createSequentialGroup()
                        .addGroup(usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqPwdUsuario)
                            .addComponent(etqUsernameUsuario)
                            .addComponent(etqApellidoUsuario)
                            .addComponent(etqNombreUsuario))
                        .addGap(18, 18, 18)
                        .addGroup(usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pwdContraseñaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txtUsernameUsuario)
                            .addComponent(txtApellidosUsuario)
                            .addComponent(txtNombreUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etqIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        usuarioLayout.setVerticalGroup(
            usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etqNombreUsuario)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etqIdUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqApellidoUsuario)
                    .addComponent(txtApellidosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqUsernameUsuario)
                    .addComponent(txtUsernameUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqPwdUsuario)
                    .addComponent(pwdContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarUsuario)
                    .addComponent(btnCancelarUsuario)
                    .addComponent(btnModificarUsuario))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        MostrarUsuarios.setTitle("Eliminar usuarios");
        MostrarUsuarios.setModal(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Usuarios");

        tblUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Usuario", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(1).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(2).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(3).setResizable(false);
        }

        btnCancelarMUsuarios.setText("Cancelar");
        btnCancelarMUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MostrarUsuariosLayout = new javax.swing.GroupLayout(MostrarUsuarios.getContentPane());
        MostrarUsuarios.getContentPane().setLayout(MostrarUsuariosLayout);
        MostrarUsuariosLayout.setHorizontalGroup(
            MostrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MostrarUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MostrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MostrarUsuariosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(243, 243, 243)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MostrarUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarMUsuarios)
                .addGap(35, 35, 35))
        );
        MostrarUsuariosLayout.setVerticalGroup(
            MostrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MostrarUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarMUsuarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        practica.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        practica.setTitle("Agregar practica");
        practica.setModal(true);
        practica.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                practicaWindowClosed(evt);
            }
        });

        etqCodigoAP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqCodigoAP.setText("Codigo:");

        etqNombreAP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqNombreAP.setText("Nombre:");

        etqSemestreAP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqSemestreAP.setText("Semestre:");

        etqCarreraAP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqCarreraAP.setText("Carrera:");

        txtCodigoPractica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCodigoPractica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoPracticaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoPracticaKeyPressed(evt);
            }
        });

        txtNombrePractica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombrePractica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePracticaKeyTyped(evt);
            }
        });

        cmbSemestrePractica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbSemestrePractica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Septimo", "Octavo", "Noveno", "Decimo" }));

        cmbCarreraPractica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbCarreraPractica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enfermería", "Medicina", "Odontología" }));

        btnAgregarPractica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAgregarPractica.setText("Agregar");
        btnAgregarPractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPracticaActionPerformed(evt);
            }
        });

        btnCancelarPractica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelarPractica.setText("Cancelar");
        btnCancelarPractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPracticaActionPerformed(evt);
            }
        });

        btnModificarPractica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificarPractica.setText("Modificar");
        btnModificarPractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPracticaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout practicaLayout = new javax.swing.GroupLayout(practica.getContentPane());
        practica.getContentPane().setLayout(practicaLayout);
        practicaLayout.setHorizontalGroup(
            practicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(practicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(practicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(practicaLayout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(btnAgregarPractica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarPractica)
                        .addGap(12, 12, 12)
                        .addComponent(btnCancelarPractica)
                        .addGap(12, 12, 12))
                    .addGroup(practicaLayout.createSequentialGroup()
                        .addGroup(practicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(practicaLayout.createSequentialGroup()
                                .addGroup(practicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etqCarreraAP)
                                    .addComponent(etqNombreAP)
                                    .addComponent(etqCodigoAP))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, practicaLayout.createSequentialGroup()
                                .addComponent(etqSemestreAP)
                                .addGap(18, 18, 18)))
                        .addGroup(practicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombrePractica, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txtCodigoPractica)
                            .addComponent(cmbSemestrePractica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCarreraPractica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        practicaLayout.setVerticalGroup(
            practicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(practicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(practicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqCodigoAP)
                    .addComponent(txtCodigoPractica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(practicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqNombreAP)
                    .addComponent(txtNombrePractica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(practicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etqCarreraAP)
                    .addGroup(practicaLayout.createSequentialGroup()
                        .addGroup(practicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etqSemestreAP)
                            .addComponent(cmbSemestrePractica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCarreraPractica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(practicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarPractica)
                    .addComponent(btnCancelarPractica)
                    .addComponent(btnModificarPractica))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        etqUsuarioMD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqUsuarioMD.setText("Usuario:");

        etqContraseñaMD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqContraseñaMD.setText("Contraseña:");

        txtNombreMD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombreMD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreMDKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreMDKeyPressed(evt);
            }
        });

        txtApellidosMD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtApellidosMD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosMDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosMDKeyTyped(evt);
            }
        });

        txtUsuarioMD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsuarioMD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioMDKeyPressed(evt);
            }
        });

        pwdContraseñaMD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pwdContraseñaMD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwdContraseñaMDKeyPressed(evt);
            }
        });

        btnAgregarMD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAgregarMD.setText("Modificar");
        btnAgregarMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMDActionPerformed(evt);
            }
        });

        btnCancelarMD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelarMD.setText("Cancelar");
        btnCancelarMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMDActionPerformed(evt);
            }
        });

        etqNombreMD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqNombreMD.setText("Nombre:");

        etqApellidoMD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etqApellidoMD.setText("Apellidos:");

        javax.swing.GroupLayout misdatosLayout = new javax.swing.GroupLayout(misdatos.getContentPane());
        misdatos.getContentPane().setLayout(misdatosLayout);
        misdatosLayout.setHorizontalGroup(
            misdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(misdatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(misdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(misdatosLayout.createSequentialGroup()
                        .addGap(0, 122, Short.MAX_VALUE)
                        .addComponent(btnAgregarMD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelarMD)
                        .addGap(12, 12, 12))
                    .addGroup(misdatosLayout.createSequentialGroup()
                        .addGroup(misdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqContraseñaMD)
                            .addComponent(etqUsuarioMD)
                            .addComponent(etqApellidoMD)
                            .addComponent(etqNombreMD))
                        .addGap(18, 18, 18)
                        .addGroup(misdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pwdContraseñaMD, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txtUsuarioMD)
                            .addComponent(txtApellidosMD)
                            .addComponent(txtNombreMD))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        misdatosLayout.setVerticalGroup(
            misdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(misdatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(misdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqNombreMD)
                    .addComponent(txtNombreMD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(misdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqApellidoMD)
                    .addComponent(txtApellidosMD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(misdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqUsuarioMD)
                    .addComponent(txtUsuarioMD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(misdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqContraseñaMD)
                    .addComponent(pwdContraseñaMD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(misdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMD)
                    .addComponent(btnCancelarMD))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        EliminarPractica.setTitle("Eliminar practica");
        EliminarPractica.setModal(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("PRACTICAS");

        tblPracticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPracticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPracticasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPracticas);

        javax.swing.GroupLayout EliminarPracticaLayout = new javax.swing.GroupLayout(EliminarPractica.getContentPane());
        EliminarPractica.getContentPane().setLayout(EliminarPracticaLayout);
        EliminarPracticaLayout.setHorizontalGroup(
            EliminarPracticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarPracticaLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(EliminarPracticaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
        );
        EliminarPracticaLayout.setVerticalGroup(
            EliminarPracticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarPracticaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CAPCR  (Control de Acceso a  Practicas en Clinica Robotizada) version .01");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("   Espere...");

        javax.swing.GroupLayout EspereLayout = new javax.swing.GroupLayout(Espere);
        Espere.setLayout(EspereLayout);
        EspereLayout.setHorizontalGroup(
            EspereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EspereLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EspereLayout.setVerticalGroup(
            EspereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EspereLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/clinica-robotizada.jpg"))); // NOI18N

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menuInicio.setText("Inicio");
        menuInicio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        itemIngresar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemIngresar.setText("Iniciar sesion");
        itemIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIngresarActionPerformed(evt);
            }
        });
        menuInicio.add(itemIngresar);

        itemSalir.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuInicio.add(itemSalir);

        itemCambiarUC.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        itemCambiarUC.setText("Modificar mis datos");
        itemCambiarUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCambiarUCActionPerformed(evt);
            }
        });
        menuInicio.add(itemCambiarUC);

        itemRealizarRegistro.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemRealizarRegistro.setText("Realizar registro");
        itemRealizarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRealizarRegistroActionPerformed(evt);
            }
        });
        menuInicio.add(itemRealizarRegistro);

        jMenuBar1.add(menuInicio);

        menuRegistro.setText("Registro");
        menuRegistro.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        itemGenerarReporte.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemGenerarReporte.setText("Generar reporte");
        itemGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGenerarReporteActionPerformed(evt);
            }
        });
        menuRegistro.add(itemGenerarReporte);

        itemHacerConsulta.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemHacerConsulta.setText("Hacer Consulta");
        itemHacerConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHacerConsultaActionPerformed(evt);
            }
        });
        menuRegistro.add(itemHacerConsulta);

        itemReporteDiario.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemReporteDiario.setText("Reporte del día");
        itemReporteDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReporteDiarioActionPerformed(evt);
            }
        });
        menuRegistro.add(itemReporteDiario);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItem1.setText("Registros cancelados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuRegistro.add(jMenuItem1);

        jMenuBar1.add(menuRegistro);

        menuAlumno.setText("Alumno");
        menuAlumno.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        itemAgregarListaAlumno.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemAgregarListaAlumno.setText("Agregar Lista");
        itemAgregarListaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarListaAlumnoActionPerformed(evt);
            }
        });
        menuAlumno.add(itemAgregarListaAlumno);

        itemAgregarAlumno.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemAgregarAlumno.setText("Agregar Alumno");
        itemAgregarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarAlumnoActionPerformed(evt);
            }
        });
        menuAlumno.add(itemAgregarAlumno);

        itemActualizarAlumno.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemActualizarAlumno.setText("Modificar Alumno");
        itemActualizarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActualizarAlumnoActionPerformed(evt);
            }
        });
        menuAlumno.add(itemActualizarAlumno);

        itemEliminarAlumno.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemEliminarAlumno.setText("Eliminar Alumno");
        itemEliminarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarAlumnoActionPerformed(evt);
            }
        });
        menuAlumno.add(itemEliminarAlumno);

        jMenuBar1.add(menuAlumno);

        menuPracticas.setText("Prácticas");
        menuPracticas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        itemAgregarListaPracticas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemAgregarListaPracticas.setText("Agregar lista");
        itemAgregarListaPracticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarListaPracticasActionPerformed(evt);
            }
        });
        menuPracticas.add(itemAgregarListaPracticas);

        itemAgregarPractica.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemAgregarPractica.setText("Agregar Práctica");
        itemAgregarPractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarPracticaActionPerformed(evt);
            }
        });
        menuPracticas.add(itemAgregarPractica);

        itemActualizarPractica.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemActualizarPractica.setText("Modificar Práctica");
        itemActualizarPractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActualizarPracticaActionPerformed(evt);
            }
        });
        menuPracticas.add(itemActualizarPractica);

        itemEliminarPracticas.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemEliminarPracticas.setText("Eliminar Práctica");
        itemEliminarPracticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarPracticasActionPerformed(evt);
            }
        });
        menuPracticas.add(itemEliminarPracticas);

        jMenuBar1.add(menuPracticas);

        menuUsuario.setText("Usuario");
        menuUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        itemNuevoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemNuevoUsuario.setText("Agregar Usuario");
        itemNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(itemNuevoUsuario);

        itemModificarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemModificarUsuario.setText("Modificar Usuario");
        itemModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(itemModificarUsuario);

        itemEliminarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        itemEliminarUsuario.setText("Eliminar Usuario");
        itemEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(itemEliminarUsuario);

        jMenuBar1.add(menuUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(Espere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(fondo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(Espere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(fondo)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    /**
     * modificar los datos de un alumno
     *
     * @param evt
     */
    private void itemActualizarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActualizarAlumnoActionPerformed
        String Matricula = JOptionPane.showInputDialog(null, "Escriba la matricula del alumno");
        /*pedir matricula*/
        if (Matricula.trim().length() != 10) {  //la matricula no es de 10 dígitos
            JOptionPane.showMessageDialog(null, "La Matricula debe de ser de 10 dígitos");
        } else {
            try {
                /*conectar la la base de datos MySQL*/
                Statement stmnt;
                stmnt = bd.conecta().createStatement();
                String sql = "call spMostrarAlumnoMatricula('" + Matricula + "');";
                ResultSet rs = stmnt.executeQuery(sql); //obtener los datos
                rs.next();
                txtMatriculaAlumno.setText(Matricula);/*la matricula no se puede modificar por que es la llave*/
                txtMatriculaAlumno.setEnabled(false);

                txtNombreAlumno.setText(rs.getString("nombre"));
                //comparacion de la carrera
                switch (rs.getString("codigoCarrera")) {
                    case "03":
                        cmbCarreraAlumno.setSelectedIndex(0);
                        break;
                    case "13":
                        this.cmbCarreraAlumno.setSelectedIndex(2);
                        break;
                    case "14":
                        this.cmbCarreraAlumno.setSelectedIndex(1);
                        break;
                }
                //convierte a entero el semestre y lo selecciona en el combobox
                cmbSemestreAlumno.setSelectedIndex((Integer.parseInt(rs.getString("codigoSemestre"))) - 1);
                //carga los grupos del semestre y selecciona el grupo al que pertenece
                validarGrupoAA(this.cmbSemestreAlumno.getSelectedIndex(), this.cmbCarreraAlumno.getSelectedIndex());
                this.cmbGrupoAlumno.setSelectedItem(rs.getString("grupo"));
                //agrega dimensiones y hace visible la ventana
                alumno.setSize(410, 277);
                alumno.setLocationRelativeTo(null);
                alumno.setVisible(true);
                btnAgregarAlumno.setVisible(false);
                //cierra la conexión
                bd.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }
        }
    }//GEN-LAST:event_itemActualizarAlumnoActionPerformed

    /**
     * para agregar un nuevo usuario solo se muestra una ventana limpia
     *
     * @param evt
     */
    private void itemNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoUsuarioActionPerformed
        usuario.setSize(350, 255);
        usuario.setLocationRelativeTo(null);
        usuario.setVisible(true);
    }//GEN-LAST:event_itemNuevoUsuarioActionPerformed

    /**
     * Modificar usuario
     *
     * @param evt
     */
    private void itemModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarUsuarioActionPerformed
        //se pide el nombre del usuario
        String nombreUsuario = JOptionPane.showInputDialog(null, "Escriba el nombre de usuario que desea modificar");
        if (nombreUsuario.trim().length() == 0) {
            //Si la casilla está vacía
            JOptionPane.showMessageDialog(null, "La casilla esta vacía");
        } else {
            try {
                //obtener los datos del alumno que se desea modificar
                Statement stmnt;
                stmnt = bd.conecta().createStatement();
                String sql = "call spMostrarUsuarioNombre('" + nombreUsuario + "');";
                ResultSet rs = stmnt.executeQuery(sql);
                rs.next();
                //como lee los datos los va agregando a los campos            
                txtNombreUsuario.setText(rs.getString("nombre"));
                txtApellidosUsuario.setText(rs.getString("apellido"));
                txtUsernameUsuario.setText(rs.getString("nombreUsuario"));
                pwdContraseñaUsuario.setText(rs.getString("contraseña"));
                etqIdUsuario.setText("" + rs.getInt("idusuario"));
                //agrega dimenciones a la ventana y la hace visible
                usuario.setSize(350, 250);
                usuario.setLocationRelativeTo(null);
                usuario.setVisible(true);
                //Cierra la conexión
                bd.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "El usuario no existe");
            }
        }

        /*bloque de codigo a revision*/
        MostrarUsuarios.setSize(550, 330);
        MostrarUsuarios.setLocationRelativeTo(null);
        MostrarUsuarios.setVisible(true);

    }//GEN-LAST:event_itemModificarUsuarioActionPerformed
    //AGREGAR PRACTICA
    private void itemAgregarPracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarPracticaActionPerformed
        practica.setSize(350, 250);
        practica.setLocationRelativeTo(null);
        btnModificarPractica.setVisible(false);
        practica.setVisible(true);
    }//GEN-LAST:event_itemAgregarPracticaActionPerformed

    //ACTUALIZAR PRACTICA
    private void itemActualizarPracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActualizarPracticaActionPerformed
        String codigo = JOptionPane.showInputDialog(null, "Escriba el código de la práctica");
        if (codigo.trim().length() != 4) {
            JOptionPane.showMessageDialog(null, "El codigo es de 4 dígitos");
        } else {
            try {
                Statement stmnt;
                stmnt = bd.conecta().createStatement();
                String sql = "select * from practica where codigo ='" + codigo + "';";
                ResultSet rs = stmnt.executeQuery(sql); //obtener los datos
                rs.next();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_itemActualizarPracticaActionPerformed
    //AGREGAR ALUMNO
    private void itemAgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarAlumnoActionPerformed
        btnModificarAlumno.setVisible(false);
        alumno.setSize(410, 277);
        alumno.setLocationRelativeTo(null);
        alumno.setVisible(true);
    }//GEN-LAST:event_itemAgregarAlumnoActionPerformed
    //LOGIN
    private void itemIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIngresarActionPerformed
        Login.setSize(400, 250);
        Login.setLocationRelativeTo(null);
        Login.setVisible(true);
    }//GEN-LAST:event_itemIngresarActionPerformed
    //REALIZAR REGISTRO
    private void itemRealizarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRealizarRegistroActionPerformed
        Vista registro = new Vista(userPrincipal.id);//Creamos el objeto y mandamos un valor para vrificar si el usuario ya ingreso o aun falta
        registro.show();
        this.dispose();
    }//GEN-LAST:event_itemRealizarRegistroActionPerformed
    //ELIMINAR ALUMNO
    private void itemEliminarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarAlumnoActionPerformed
        String Matricula = JOptionPane.showInputDialog(null, "Escriba la matricula del alumno:");
        if (Matricula.length() == 10) {
            Alumno ealumno = new Alumno(Matricula);
            if (ealumno.BuscarAlumno() != 0) {
                int DialogResult = JOptionPane.showConfirmDialog(null, "Desea eliminar el alumno permanentemente \n(Se borrarán todos los datos)");
                switch (DialogResult) {
                    case JOptionPane.YES_OPTION:
                        ealumno.EliminarAlumnoPermanente();
                        break;
                    case JOptionPane.NO_OPTION:
                        ealumno.EliminarAlumno();
                        break;
                    default:
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe...");
            }
        } else {

        }
    }//GEN-LAST:event_itemEliminarAlumnoActionPerformed
    //LOG OUT
    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        userPrincipal.tipo = 0;
        valores(userPrincipal.tipo);
    }//GEN-LAST:event_itemSalirActionPerformed
    //CARGAR LA LISTA DE EXCCEL DE LOS ALUMNOS
    private void itemAgregarListaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarListaAlumnoActionPerformed
        Espere.setVisible(true);
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Seleccione un archivo Excel");
        FileNameExtensionFilter filtroArchivo = new FileNameExtensionFilter("xlsx", "xlsx");
        selector.setFileFilter(filtroArchivo);
        int flag = selector.showOpenDialog(null);
        //COMPROBAMOS QUE HAYA PULSADO ACEPTAR
        if (flag == JFileChooser.APPROVE_OPTION) {
            try {
                String ruta = selector.getSelectedFile().getPath();
                ExtraerAlumno a = new ExtraerAlumno();
                a.extraer(ruta);
                Espere.setVisible(false);
                JOptionPane.showMessageDialog(null, "Datos insertados");
            } catch (HeadlessException e) {
                System.out.println(e.getMessage());
            }
        }
        Espere.setVisible(false);
    }//GEN-LAST:event_itemAgregarListaAlumnoActionPerformed
    //CARGAR LA LISTA DE EXCCEL DE LAS PRACTICAS
    private void itemAgregarListaPracticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarListaPracticasActionPerformed
        Espere.setVisible(true);
        JFileChooser selector = new JFileChooser();
        ExtraerPractica a = new ExtraerPractica();
        selector.setDialogTitle("Seleccione un archivo Excel");
        FileNameExtensionFilter filtroArchivo = new FileNameExtensionFilter("xlsx", "xlsx");
        selector.setFileFilter(filtroArchivo);
        int flag = selector.showOpenDialog(null);
        //COMPROBAMOS QUE HAYA PULSADO ACEPTAR
        if (flag == JFileChooser.APPROVE_OPTION) {
            try {
                String ruta = selector.getSelectedFile().getPath();
                a.extraer(ruta);
                Espere.setVisible(false);
                JOptionPane.showMessageDialog(null, "Datos insertados");
            } catch (HeadlessException e) {
                System.out.println(e.getMessage());
            }
        }
        Espere.setVisible(false);
    }//GEN-LAST:event_itemAgregarListaPracticasActionPerformed

    //MOSTRAR LA LISTA DE LOS USUARIOS CREADOS POR EL ROOT
    private void itemEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarUsuarioActionPerformed
        TablaUsuario = new DefaultTableModel();
        this.tblUsuarios.setModel(TablaUsuario);
        TablaUsuario.addColumn("Nombre");

        TablaUsuario.addColumn("Apellidos");
        TablaUsuario.addColumn("Usuario");
        TablaUsuario.addColumn("Contraseña");
        //redimencionar el ancho de las columnas
        TableColumn columna;
        for (int i = 0; i < 4; i++) {
            columna = tblUsuarios.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    columna.setPreferredWidth(150);
                    break;
                case 1:
                    columna.setPreferredWidth(150);
                    break;
                case 2:
                    columna.setPreferredWidth(100);
                    break;
                case 3:
                    columna.setPreferredWidth(100);
                    break;
            }
        }
        bd.conecta();
        try {
            Statement stmnt;
            stmnt = bd.conecta().createStatement();
            String sql = "call spmostrarUsuarios();";
            ResultSet rs = stmnt.executeQuery(sql);
            while (rs.next()) {
                TablaUsuario.addRow(new Object[]{rs.getString("nombre"), rs.getString("apellido"), rs.getString("nombreUsuario"), rs.getString("contraseña")});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        bd.close();
        MostrarUsuarios.setSize(550, 330);
        MostrarUsuarios.setLocationRelativeTo(null);
        MostrarUsuarios.setVisible(true);

    }//GEN-LAST:event_itemEliminarUsuarioActionPerformed
    //MODIFICAR MIS DATOS
    private void itemCambiarUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCambiarUCActionPerformed
        userPrincipal.MostrarUsuarioId();
        this.txtApellidosMD.setText(userPrincipal.Apellido);
        this.txtNombreMD.setText(userPrincipal.Nombre);
        this.txtUsuarioMD.setText(userPrincipal.Usuario);
        this.pwdContraseñaMD.setText(userPrincipal.Password);
        misdatos.setSize(350, 250);
        misdatos.setLocationRelativeTo(null);
        misdatos.setVisible(true);

    }//GEN-LAST:event_itemCambiarUCActionPerformed

    //BOTON CANCELAR
    private void btnCancelarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlumnoActionPerformed
        limpiarPantallaAlumno();
        alumno.dispose();
    }//GEN-LAST:event_btnCancelarAlumnoActionPerformed
    //BOTON AGREGAR
    private void btnAgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlumnoActionPerformed
        String Matricula = this.txtMatriculaAlumno.getText();
        if (Matricula.trim().length() == 10) {
            String Nombre = this.txtNombreAlumno.getText().toUpperCase();
            String Carrera = Codigo.ObtenerCodigoCarrera(this.cmbCarreraAlumno.getItemAt(this.cmbCarreraAlumno.getSelectedIndex()).toUpperCase());
            String Semestre = Codigo.ObtenerCodigoSemestre(this.cmbSemestreAlumno.getItemAt(this.cmbSemestreAlumno.getSelectedIndex()).toUpperCase());
            String Grupo = "";
            try {
                //como obtener el texto en vez de obtener un item seleccionado
                Grupo = this.cmbGrupoAlumno.toString();
            } catch (Exception ex) {
                System.out.println("error al cargar alumno");
            }
            if (Nombre.length() == 0) {
                JOptionPane.showMessageDialog(null, "Escriba el nombre del alumno");
            } else {
                System.out.println(Matricula + " " + Nombre + " " + Grupo + " " + Semestre + " " + Carrera);
                Alumno ialumno = new Alumno(Matricula, Nombre, Grupo, Semestre, Carrera);
                //ialumno.AgregarAlumno();
                limpiarPantallaAlumno();
                alumno.dispose();
            }
        } else {
            if (this.txtNombreAlumno.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "casillas vacias");
            } else {
                JOptionPane.showMessageDialog(null, "La matricula debe contener 10 digitos");
            }
        }

        limpiarPantallaAlumno();
        this.txtMatriculaAlumno.requestFocus();
    }//GEN-LAST:event_btnAgregarAlumnoActionPerformed

    //      VALIDACION 
    private void txtMatriculaAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaAlumnoKeyTyped
        validarNumero(evt);
        if (txtMatriculaAlumno.getText().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMatriculaAlumnoKeyTyped

    private void txtNombreAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreAlumnoKeyTyped
        validarLetra(evt);
    }//GEN-LAST:event_txtNombreAlumnoKeyTyped

    //      TECLEAR ENTER
    private void txtMatriculaAlumnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaAlumnoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.txtNombreAlumno.requestFocus();
        }

    }//GEN-LAST:event_txtMatriculaAlumnoKeyPressed

    private void txtNombreAlumnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreAlumnoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        }
    }//GEN-LAST:event_txtNombreAlumnoKeyPressed

    /**
     * ************************************************************************************************************************************
     * JDIALOG AGREGAR USUARIO
     */
    //BOTON CANCELAR
    private void btnCancelarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarUsuarioActionPerformed
        limpiarPantallaUsuario();
        usuario.dispose();
    }//GEN-LAST:event_btnCancelarUsuarioActionPerformed
    //BOTON AGREGAR
    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        // SE TOMAN LOS VALORES DE LA VENTANA
        String Nombre = this.txtNombreUsuario.getText();
        String Apellidos = this.txtApellidosUsuario.getText();
        String NombreUsuario = this.txtUsernameUsuario.getText();
        String contraseña = this.pwdContraseñaUsuario.getText();
        Nombre = validarTexto(Nombre);
        Apellidos = validarTexto(Apellidos);
        NombreUsuario = validarTexto(NombreUsuario);
        contraseña = validarTexto(contraseña);
        //REVISA QUE NINGUNA CASILLA ESTE VACIA
        if (Nombre.length() == 0 || Apellidos.length() == 0 || NombreUsuario.length() == 0 || contraseña.length() == 0) {
            JOptionPane.showMessageDialog(null, "Alguna casilla esta vacía", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //SE CONECTA A LA BASE DE DATOS 
            Usuario user = new Usuario(Nombre, Apellidos, NombreUsuario, contraseña, 2);
            user.InsertarUsuario();
            usuario.dispose();
        }
        limpiarPantallaUsuario();
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    //      VALIDACION 
    private void txtNombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyTyped
        validarLetra(evt);
    }//GEN-LAST:event_txtNombreUsuarioKeyTyped

    private void txtApellidosUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosUsuarioKeyTyped
        validarLetra(evt);
    }//GEN-LAST:event_txtApellidosUsuarioKeyTyped

    //      TECLEAR ENTER
    private void txtNombreUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.txtApellidosUsuario.requestFocus();
        }
    }//GEN-LAST:event_txtNombreUsuarioKeyPressed

    private void txtApellidosUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.txtUsernameUsuario.requestFocus();
        }
    }//GEN-LAST:event_txtApellidosUsuarioKeyPressed

    private void txtUsernameUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.pwdContraseñaUsuario.requestFocus();
        }
    }//GEN-LAST:event_txtUsernameUsuarioKeyPressed

    /**
     * **************************************************************************************************************************************
     * JDIALOG AGREGAR PRACTICA
     */
    //BOTON CANCELAR
    private void btnCancelarPracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPracticaActionPerformed
        limpiarPantallaPractica();
        practica.dispose();
    }//GEN-LAST:event_btnCancelarPracticaActionPerformed
    //BOTON AGREGAR
    private void btnAgregarPracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPracticaActionPerformed
        String codigo = this.txtCodigoPractica.getText();
        String nombre = this.txtNombrePractica.getText().toUpperCase();
        String semestre = Codigo.ObtenerCodigoSemestre(this.cmbSemestrePractica.getItemAt(this.cmbSemestrePractica.getSelectedIndex()).toUpperCase().trim());
        String carrera = Codigo.ObtenerCodigoCarrera(this.cmbCarreraPractica.getItemAt(this.cmbCarreraPractica.getSelectedIndex()).toUpperCase().trim());
        Practica apractica = new Practica(codigo, nombre, carrera, semestre);
        apractica.AgregarPractica();
        limpiarPantallaPractica();
        practica.setVisible(false);
    }//GEN-LAST:event_btnAgregarPracticaActionPerformed

    //      VALIDACION
    private void txtCodigoPracticaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPracticaKeyTyped
        validarNumero(evt);
        if (txtCodigoPractica.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoPracticaKeyTyped
    private void txtCodigoPracticaKeyPressed(java.awt.event.KeyEvent evt) {

    }

    //PENDIENTE
    private void txtNombrePracticaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePracticaKeyTyped
        validarLetra(evt);
    }//GEN-LAST:event_txtNombrePracticaKeyTyped

    /**
     * cancela el proceso limpia la pantalla quita la ventana
     *
     * @param evt
     */
    private void btnCancelarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarLActionPerformed
        limpiarPantallaL();
        Login.setVisible(false);
    }//GEN-LAST:event_btnCancelarLActionPerformed
    /**
     * llama a la funcion Ingresar
     *
     * @param evt
     */
    private void btnIngresarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarLActionPerformed
        try {
            ingresar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnIngresarLActionPerformed
    /**
     * verifica si la caja de texto de contraseña este llena si es asi comienza
     * con el login caso contrario manda el focus al cuadro de contraseña para
     * que se rellene
     *
     * @param evt
     */
    private void txtUsuarioLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioLKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.pwdContraseñaL.getText().length() < 1) {
                this.pwdContraseñaL.requestFocus();
            } else {
                try {

                    ingresar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_txtUsuarioLKeyPressed
    /**
     * el presionar ENTER en el cuadro de texto Contraseña comienza el login
     *
     * @param evt
     */
    private void pwdContraseñaLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdContraseñaLKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                ingresar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_pwdContraseñaLKeyPressed

    /**
     * por cada que se cierra los JDialog llama al metodo encargado de limpiar
     * la pantalla
     */
    private void LoginWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_LoginWindowClosed
        limpiarPantallaL();
    }//GEN-LAST:event_LoginWindowClosed
    private void alumnoWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_alumnoWindowClosed
        limpiarPantallaAlumno();
    }//GEN-LAST:event_alumnoWindowClosed
    private void usuarioWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_usuarioWindowClosed
        limpiarPantallaUsuario();
    }//GEN-LAST:event_usuarioWindowClosed
    private void practicaWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_practicaWindowClosed
        limpiarPantallaPractica();
    }//GEN-LAST:event_practicaWindowClosed

    /**
     * se cancela la operacion a realizar cierra la ventana
     */
    private void btnCancelarMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMDActionPerformed
        misdatos.dispose();
    }//GEN-LAST:event_btnCancelarMDActionPerformed

    /**
     * obtiene los datos del usuario de los campos de texto los guarda en una
     * clase y luego llama el metodo encargado de modificar los datos
     */
    private void btnAgregarMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMDActionPerformed
        userPrincipal.Nombre = this.txtNombreMD.getText();
        userPrincipal.Apellido = this.txtApellidosMD.getText();
        userPrincipal.Usuario = this.txtUsuarioMD.getText();
        userPrincipal.Password = this.pwdContraseñaMD.getText();
        //metodo encargado de modificar los datos del usuario
        userPrincipal.ModificarUsuario();
        misdatos.dispose();

    }//GEN-LAST:event_btnAgregarMDActionPerformed

    /**
     * valida cada tecla presionada para asi permitir solo la entrada de numeros
     * o letras
     *
     * @param evt
     */
    private void txtNombreMDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreMDKeyTyped
        this.validarLetra(evt);
    }//GEN-LAST:event_txtNombreMDKeyTyped
    private void txtApellidosMDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosMDKeyTyped
        this.validarLetra(evt);
    }//GEN-LAST:event_txtApellidosMDKeyTyped

    /**
     * al presionar ENTER estas cajas de texto cambian el focus a la siguiente
     * caja
     *
     * @param evt
     */
    private void txtNombreMDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreMDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.txtApellidosMD.requestFocus();
        }

    }//GEN-LAST:event_txtNombreMDKeyPressed
    private void txtApellidosMDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosMDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.txtUsuarioMD.requestFocus();
        }
    }//GEN-LAST:event_txtApellidosMDKeyPressed
    private void txtUsuarioMDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioMDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.pwdContraseñaMD.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioMDKeyPressed
    private void pwdContraseñaMDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdContraseñaMDKeyPressed

    }//GEN-LAST:event_pwdContraseñaMDKeyPressed

    /**
     * crea la ventana registro y cierra el menu principal
     *
     * @param evt
     */
    private void itemReporteDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReporteDiarioActionPerformed
        RegistroDiario registro = new RegistroDiario(this.userPrincipal.id);
        registro.show();
        this.dispose();
    }//GEN-LAST:event_itemReporteDiarioActionPerformed

    /**
     * por cada que cambie el combobox de carrera se cambian los datos del
     * combobox grupo referente a esa carrera
     *
     * @param evt
     */
    private void cmbCarreraAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCarreraAlumnoActionPerformed
        validarGrupoAA(this.cmbSemestreAlumno.getSelectedIndex(), this.cmbCarreraAlumno.getSelectedIndex());
    }//GEN-LAST:event_cmbCarreraAlumnoActionPerformed

    /**
     * por cada que cambie de semestre se actualiza el combobox del grupo
     *
     * @param evt
     */
    private void cmbSemestreAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSemestreAlumnoActionPerformed
        validarGrupoAA(this.cmbSemestreAlumno.getSelectedIndex(), this.cmbCarreraAlumno.getSelectedIndex());
    }//GEN-LAST:event_cmbSemestreAlumnoActionPerformed

    /**
     * cierra la ventana principal y entra a la ventana consulta
     *
     * @param evt
     */
    private void itemHacerConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHacerConsultaActionPerformed
        Consulta consulta = new Consulta(userPrincipal.id);
        consulta.show();
        this.dispose();
    }//GEN-LAST:event_itemHacerConsultaActionPerformed

    private void cmbGrupoAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGrupoAlumnoActionPerformed
    }//GEN-LAST:event_cmbGrupoAlumnoActionPerformed

    /**
     * llama al JDialog que tiene la tabla de las practicas carga la tabla con
     * las practicas existentes
     *
     * @param evt
     */
    private void itemEliminarPracticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarPracticasActionPerformed
        // crea un nuevo modelo para la tabla
        TablaPractica = new DefaultTableModel();
        this.tblPracticas.setModel(TablaPractica);

        //agregamos filas al modelo
        TablaPractica.addColumn("Codigo");
        TablaPractica.addColumn("Nombre");
        TablaPractica.addColumn("Semestre");
        TablaPractica.addColumn("Carrera");

        //recorre columnas para agregar dimensiones
        TableColumn columna;
        for (int i = 0; i < 4; i++) {
            columna = tblPracticas.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    columna.setPreferredWidth(50);
                    break;
                case 1:
                    columna.setPreferredWidth(150);
                    break;
                case 2:
                    columna.setPreferredWidth(100);
                    break;
                case 3:
                    columna.setPreferredWidth(100);
                    break;
            }
        }
        //conecta a la base de datos
        bd.conecta();

        String codigo, nombre, semestre, carrera;
        try {
            Statement stmnt;
            stmnt = bd.conecta().createStatement();
            // hacer una consulta para obtener los datos de las practicas
            String sql = "select p.codigo,p.nombre,s.nombre as semestre,c.nombre as carrera from practica p inner join semestre s on "
                    + "p.codigoSemestre=s.codigo inner join carrera c on p.codigoCarrera= c.codigo where fechaEliminacion is null;";
            ResultSet rs = stmnt.executeQuery(sql);
            while (rs.next()) {
                //guarda los valores
                nombre = rs.getString("nombre");// se guarda en int de la columna tipo a la variable a
                codigo = rs.getString("codigo");
                semestre = rs.getString("semestre");
                carrera = rs.getString("carrera");
                //inserta los valores obtenidos en la tabla
                TablaPractica.addRow(new Object[]{codigo, nombre, semestre, carrera});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        bd.close();
        // crea las dimensiones del JDialog
        EliminarPractica.setSize(550, 330);
        EliminarPractica.setLocationRelativeTo(null);
        EliminarPractica.setVisible(true);
    }//GEN-LAST:event_itemEliminarPracticasActionPerformed

    /**
     * Recibe la fila seleccionada y obtiene el username del usuario llama al
     * metodo eliminar usuario de la clase usuario
     *
     * @param evt
     */
    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        int RowSelect;
        try {
            RowSelect = this.tblUsuarios.getSelectedRow();
            if (RowSelect == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");
            } else {
                Usuario user = new Usuario();
                //Pide confirmar que se desea eliminar para no eliminar usuarios por error
                int DialogResult = JOptionPane.showConfirmDialog(null, "Desea eliminar este usuario? \n" + (String) this.tblUsuarios.getValueAt(RowSelect, 2));
                if (DialogResult == JOptionPane.YES_OPTION) {
                    //llama el metodo eliminar usuario
                    user.EliminarUsuario((String) this.tblUsuarios.getValueAt(RowSelect, 2));
                    //elimina la fila del usuario para no actualizar la tabla
                    TablaUsuario.removeRow(RowSelect);
                }
            }
        } catch (HeadlessException e) {
            // si hay un error en el proceso
            System.out.println("Error al captar datos");
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    /**
     * cierra la ventana principal y entra al frame que genera el reporte envia
     * el id del usuario para los privilegios
     *
     * @param evt
     */
    private void itemGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGenerarReporteActionPerformed
        Reporte re = new Reporte(userPrincipal.id);
        re.show();
        this.dispose();
    }//GEN-LAST:event_itemGenerarReporteActionPerformed

    /**
     * Cierra el JDialog MostrarUsuarios
     *
     * @param evt
     */
    private void btnCancelarMUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMUsuariosActionPerformed
        MostrarUsuarios.dispose();
    }//GEN-LAST:event_btnCancelarMUsuariosActionPerformed

    /**
     * cierra la ventana menu principal y abre la ventana de los registros
     * cancelados
     *
     * @param evt
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //crea un objeto del frame y lo muestra en pantalla
        RegistrosCancelados registro = new RegistrosCancelados(this.userPrincipal.id);
        registro.show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * seleccionar una fila que se desea eliminar pregunta si se desea un delete
     * permanente logico: solo actualiza el campo fecha de eliminacion
     * permanente: lo borra del sistema (ya no se pueden recuperar los datos)
     *
     * @param evt
     */
    private void tblPracticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPracticasMouseClicked
        int RowSelect;
        try {
            /* busca la fila que se ha seleccionado */
            RowSelect = this.tblPracticas.getSelectedRow();
            if (RowSelect == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila");
            } else {
                /* recoje el codigo de la practica -> valor unico de cada practica */
                String codigo = (String) TablaPractica.getValueAt(RowSelect, 0);

                int DialogResult = JOptionPane.showConfirmDialog(null, "Desea eliminar esta practica permanentemente? ");
                /* dos opciones de eliminación */
                Practica epractica = new Practica(codigo);
                switch (DialogResult) {
                    case JOptionPane.YES_OPTION:
                        epractica.EliminarPracticaPrermanente();
                        TablaPractica.removeRow(RowSelect);
                        break;
                    case JOptionPane.NO_OPTION:
                        epractica.EliminarPractica();
                        TablaPractica.removeRow(RowSelect);
                        break;
                    default:
                        break;
                }
            }
        } catch (HeadlessException e) {
            System.out.println("Error: eliminar practica \n " + e.getMessage());
        }
    }//GEN-LAST:event_tblPracticasMouseClicked

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void btnModificarPracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPracticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarPracticaActionPerformed

    /**
     * validación: acepta solo numeros si no es numero lo consume, hace que
     * desaparezca
     *
     * @param evt
     */
    public void validarNumero(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }

    /**
     * validacion: acepta solo letras consume los numeros
     *
     * @param evt -> tecla presionada
     */
    public void validarLetra(java.awt.event.KeyEvent evt) {
        char n = evt.getKeyChar();
        if (Character.isDigit(n)) {
            getToolkit().beep();
            evt.consume();
        }
    }

    /**
     * validarGrupo actualiza el comboBox del grupo dependiendo del semestre y
     * carrera
     *
     * @param a -> semestre
     * @param b -> carrera
     */
    public void validarGrupoAlumno(int a, int b) {
        switch (b) {
            case 0://ENFERMERIA
                cmbGrupoAlumno.removeAllItems();
                cmbGrupoAlumnoAddItems(a + 1, "03");
                break;
            case 1://MEDICINA
                cmbGrupoAlumno.removeAllItems();
                cmbGrupoAlumnoAddItems(a + 1, "14");
                break;
            case 2://ODONOTOLOGIA
                cmbGrupoAlumno.removeAllItems();
                cmbGrupoAlumnoAddItems(a + 1, "13");
                break;
        }
    }

    /**
     * Add items: busca en la Base de datos grupos del semestre y carrera
     *
     * @param Sem -> semestre
     * @param Carrera -> carrera
     */
    public void cmbGrupoAlumnoAddItems(int Sem, String Carrera) {
        String Semestre;
        /* si el semestre es menor a 10 necesita llevar un 0 antes de. */
        if (Sem >= 10) {
            Semestre = Sem + "";
        } else {
            Semestre = "0" + Sem;
        }
        // Conectar a la base de datos
        bd.conecta();
        try {
            Statement stmnt;
            stmnt = bd.conecta().createStatement();
            // llamar al procedimiento almacenado: Mostrar grupo
            String sql = "call spMostrarGrupoSemestre('" + Semestre + "','" + Carrera + "');";
            ResultSet rs = stmnt.executeQuery(sql);
            while (rs.next()) {
                //agrega la lista al combobox
                cmbGrupoAlumno.addItem(rs.getString("grupo"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //cerrar la base de datos
        bd.close();
    }

    /**
     * funcion: ValidarGrupoAA -> Agregar alumno valores obtenidos del
     * IndexSelected de los combobox
     *
     * @param a -> semestre
     * @param b -> carrera
     */
    public void validarGrupoAA(int a, int b) {
        switch (b) {
            case 0:                                 //Enfermería 
                // Limpia el combobox Agregar alumno
                this.cmbGrupoAlumno.removeAllItems();
                AAcomboGrupoAddItems(a + 1, "03");
                break;
            case 1:                                 //Medicina
                this.cmbGrupoAlumno.removeAllItems();
                AAcomboGrupoAddItems(a + 1, "14");
                break;
            case 2:                                 //Odontología
                this.cmbGrupoAlumno.removeAllItems();
                AAcomboGrupoAddItems(a + 1, "13");
                break;
        }
    }

    /**
     * Agrega los grupos que hay en dicho semestre y carrera
     *
     * @param Sem -> valor entero
     * @param Carrera -> cadena
     */
    public void AAcomboGrupoAddItems(int Sem, String Carrera) {
        String Semestre;
        if (Sem >= 10) {
            Semestre = Sem + "";
        } else {
            Semestre = "0" + Sem;
        }
        bd.conecta();
        try {
            Statement stmnt;
            stmnt = bd.conecta().createStatement();
            String sql = "call spMostrarGrupoSemestre('" + Semestre + "','" + Carrera + "');";
            ResultSet rs = stmnt.executeQuery(sql);
            while (rs.next()) {
                this.cmbGrupoAlumno.addItem(rs.getString("grupo"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        bd.close();
    }

    /**
     * ValidarTexto recibe una cadena, si la cadena tiene apostrofe -> ' escribe
     * una diagonal invertida para que este sea aceptado en la base de datos
     *
     * @param a -> "conserj'e"
     * @return -> "conserj\'e"
     */
    public String validarTexto(String a) {
        String parte1, parte2, c = "'";
        for (int i = 0; i < a.length(); i++) {
            if (a.substring(i, i + 1) == null ? c == null : a.substring(i, i + 1).equals(c)) {
                parte1 = a.substring(0, i);
                parte2 = a.substring(i, a.length());
                a = parte1 + "\\" + parte2;
                i++;
            }
        }
        return a;
    }

    /* Ingresar al sistema con su usuario y contraseña */
    public void ingresar() throws SQLException {
        // Obtener valores
        String nombre = this.txtUsuarioL.getText();
        String contraseña = this.pwdContraseñaL.getText();

        //Validacion del texto
        nombre = validarTexto(nombre);
        contraseña = validarTexto(contraseña);

        // crea objeto con los valores obtenidos
        Usuario user = new Usuario(nombre, contraseña);

        /**
         * funcion loginUsuario realiza una busqueda en la base de datos retorna
         * arreglo de 2 enteros a[0] -> tipo a[1] -> id
         */
        int[] a = user.loginUsuario();
        if (a[0] != 0) {
            // agrega los valores a la clase
            userPrincipal.tipo = a[0];
            userPrincipal.id = a[1];

            // se abren las ventanas para este tipo de usuario
            valores(userPrincipal.tipo);
            Login.dispose();

        } else /* no hay nigun usuario con ese nombre y contraseña */ {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos ");
        }

        /**
         * ya sea exitoso o erroneo el login limpia la pantalla y agrega focus
         * al primer parametro
         */
        limpiarPantallaL();
        this.txtUsuarioL.requestFocus();

    }

    /**
     * limpieza de pantallas la funcion limpiar pantalla es para borrar los
     * datos insertados solo agrega texto vacío en donde fueron insertados los
     * datos
     */
    /*alumno*/
    public void limpiarPantallaAlumno() {
        this.txtMatriculaAlumno.setText(null);
        this.txtNombreAlumno.setText(null);
        this.cmbCarreraAlumno.setSelectedIndex(0);
        this.cmbSemestreAlumno.setSelectedIndex(0);
    }

    /*usuario */
    public void limpiarPantallaUsuario() {
        txtApellidosUsuario.setText(null);
        txtNombreUsuario.setText(null);
        txtUsernameUsuario.setText(null);
        pwdContraseñaUsuario.setText(null);
    }

    /*práctica*/
    public void limpiarPantallaPractica() {
        txtCodigoPractica.setText(null);
        txtNombrePractica.setText(null);
        cmbCarreraPractica.setSelectedIndex(0);
        cmbSemestrePractica.setSelectedIndex(0);
    }

    /**
     * para evitar mostrar usuario y contraseña de usuarios ingresados
     * anteriormente se limpia la pantalla Login
     */
    public void limpiarPantallaL() {
        this.txtUsuarioL.setText(null);
        this.pwdContraseñaL.setText(null);
    }

    /**
     * metodo main
     */
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">      
        try {
            //SELECCIONAMOS EL ESTILO DE NUESTRAS VENTANAS
            Properties props = new Properties();
            props.put("logoString", "...");

            props.put("licenseKey", "INSERT YOUR LICENSE KEY HERE");

            props.put("selectionBackgroundColor", "180 240 197");
            props.put("menuSelectionBackgroundColor", "180 240 197");
            props.put("menuSelectionBackgroundColorLight", "218 254 230");
            props.put("menuSelectionBackgroundColorDark", "180 240 197");
            props.put("menuSelectionForegroundColor", "0 0 0");

            props.put("buttonColor", "218 230 254");
            props.put("buttonColorLight", "255 255 255");
            props.put("buttonColorDark", "244 242 232");

            props.put("rolloverColor", "218 254 230");
            props.put("rolloverColorLight", "218 254 230");
            props.put("rolloverColorDark", "180 240 197");

            props.put("windowTitleForegroundColor", "255 255 255");
            props.put("windowTitleBackgroundColor", "0 0 0");
            props.put("windowTitleColorLight", "0 150 100");
            props.put("windowTitleColorDark", "0 97 54");
            props.put("windowBorderColor", "0 0 0");
            GraphiteLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            // start application
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // variables de modelo de las tablas
    private DefaultTableModel TablaUsuario;
    private DefaultTableModel TablaPractica;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog EliminarPractica;
    private javax.swing.JPanel Espere;
    private javax.swing.JDialog Login;
    private javax.swing.JDialog MostrarUsuarios;
    private javax.swing.JDialog alumno;
    private javax.swing.JButton btnAgregarAlumno;
    private javax.swing.JButton btnAgregarMD;
    private javax.swing.JButton btnAgregarPractica;
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnCancelarAlumno;
    private javax.swing.JButton btnCancelarL;
    private javax.swing.JButton btnCancelarMD;
    private javax.swing.JButton btnCancelarMUsuarios;
    private javax.swing.JButton btnCancelarPractica;
    private javax.swing.JButton btnCancelarUsuario;
    private javax.swing.JButton btnIngresarL;
    private javax.swing.JButton btnModificarAlumno;
    private javax.swing.JButton btnModificarPractica;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JComboBox<String> cmbCarreraAlumno;
    private javax.swing.JComboBox<String> cmbCarreraPractica;
    private javax.swing.JComboBox<String> cmbGrupoAlumno;
    private javax.swing.JComboBox<String> cmbSemestreAlumno;
    private javax.swing.JComboBox<String> cmbSemestrePractica;
    private javax.swing.JLabel etqApellidoMD;
    private javax.swing.JLabel etqApellidoUsuario;
    private javax.swing.JLabel etqCarreraAA;
    private javax.swing.JLabel etqCarreraAP;
    private javax.swing.JLabel etqCodigoAP;
    private javax.swing.JLabel etqContraseñaL;
    private javax.swing.JLabel etqContraseñaMD;
    private javax.swing.JLabel etqGrupoAA;
    private javax.swing.JLabel etqIdUsuario;
    private javax.swing.JLabel etqLoginL;
    private javax.swing.JLabel etqMatriculaAA;
    private javax.swing.JLabel etqNombreAA;
    private javax.swing.JLabel etqNombreAP;
    private javax.swing.JLabel etqNombreMD;
    private javax.swing.JLabel etqNombreUsuario;
    private javax.swing.JLabel etqPwdUsuario;
    private javax.swing.JLabel etqSemestreAA;
    private javax.swing.JLabel etqSemestreAP;
    private javax.swing.JLabel etqUsernameUsuario;
    private javax.swing.JLabel etqUsuarioL;
    private javax.swing.JLabel etqUsuarioMD;
    private javax.swing.JLabel fondo;
    private javax.swing.JMenuItem itemActualizarAlumno;
    private javax.swing.JMenuItem itemActualizarPractica;
    private javax.swing.JMenuItem itemAgregarAlumno;
    private javax.swing.JMenuItem itemAgregarListaAlumno;
    private javax.swing.JMenuItem itemAgregarListaPracticas;
    private javax.swing.JMenuItem itemAgregarPractica;
    private javax.swing.JMenuItem itemCambiarUC;
    private javax.swing.JMenuItem itemEliminarAlumno;
    private javax.swing.JMenuItem itemEliminarPracticas;
    private javax.swing.JMenuItem itemEliminarUsuario;
    private javax.swing.JMenuItem itemGenerarReporte;
    private javax.swing.JMenuItem itemHacerConsulta;
    private javax.swing.JMenuItem itemIngresar;
    private javax.swing.JMenuItem itemModificarUsuario;
    private javax.swing.JMenuItem itemNuevoUsuario;
    private javax.swing.JMenuItem itemRealizarRegistro;
    private javax.swing.JMenuItem itemReporteDiario;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuAlumno;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenu menuPracticas;
    private javax.swing.JMenu menuRegistro;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JDialog misdatos;
    private javax.swing.JDialog practica;
    private javax.swing.JPasswordField pwdContraseñaL;
    private javax.swing.JPasswordField pwdContraseñaMD;
    private javax.swing.JPasswordField pwdContraseñaUsuario;
    private javax.swing.JTable tblPracticas;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellidosMD;
    private javax.swing.JTextField txtApellidosUsuario;
    private javax.swing.JTextField txtCodigoPractica;
    private javax.swing.JTextField txtMatriculaAlumno;
    private javax.swing.JTextField txtNombreAlumno;
    private javax.swing.JTextField txtNombreMD;
    private javax.swing.JTextField txtNombrePractica;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtUsernameUsuario;
    private javax.swing.JTextField txtUsuarioL;
    private javax.swing.JTextField txtUsuarioMD;
    private javax.swing.JDialog usuario;
    // End of variables declaration//GEN-END:variables
}
