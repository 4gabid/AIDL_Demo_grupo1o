## Para executar o código, clone ou faça download do repositório e utilize o emulador Android.

A interface AIDL possui 3 métodos, implementados no Demo Service: 
  somar - Soma dois números.
  mudar_cor - Muda a cor do botão de “Somar” retornando uma cor RGB de forma aleatória
  mandar_mensagem - Função criada para enviar mensagem para o LogCat (resultado da soma).

### Demonstração da atividade:
**On resume:**
Ao resumir a aplicação, o método soma será invocado com 2 e 3 valores padrão.
Para demonstrar, clique no botão Home no emulador (o círculo na barra do emulador ou barra inferior do dispositivo emulado) e depois reabra a aplicação.
No Logcat, filtre pela tag AIDL_DEMO e o resultado aparecerá no log.

**Usando o aplicativo:**
Ao inserir dois números nos campos de texto e clicar no botão Somar:
   - o método somar será invocado com os valores inseridos pelo usuário;
   - o resultado será utilizado no método mandar mensagem: filtre no log cat com a tag Demo_Service para ver a mensagem com o resultado;
   - o resultado da soma será utilizado como seed do método random, que gerará um valor aleatório de cor(r,g,b) e alterará a cor de fundo do botão.

**Versão do Android Studio Utilizada:**


![image](https://github.com/user-attachments/assets/27b7f447-011e-4556-b41e-98dbf37cc3b6)


Android Studio Ladybug | 2024.2.1 Patch 3
Build #AI-242.23339.11.2421.12700392, built on November 22, 2024
Runtime version: 21.0.3+-12282718-b509.11 amd64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
Toolkit: sun.awt.X11.XToolkit
Linux 5.15.0-131-generic
GC: G1 Young Generation, G1 Concurrent GC, G1 Old Generation
Memory: 2048M
Cores: 16
Registry:
  ide.experimental.ui=true
  i18n.locale=
Current Desktop: ubuntu:GNOME



AOSP – GRUPO 10: 
Cleberson dos Santos Machado
Gabrielle Desireé Cardoso de Souza
Manoel Felipe Costa Almeida Fernandes
Nainde Cardoso Lago Pinheiro


