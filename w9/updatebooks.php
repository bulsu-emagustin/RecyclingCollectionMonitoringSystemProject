<?php 
  require "config.php";

  session_start();
  if (!isset($_SESSION["login_data"]))
  {
    header('Location: index.php');
    exit();
  }

  $bookid = $_GET["id"];

  try{
    
    require 'db/action/dbconfig.php';

    $stmt = "SELECT * FROM books WHERE id='$bookid'";
    
    $query = $conn->query($stmt);
    $result = $query->fetchAll(PDO::FETCH_ASSOC);

    // var_dump($result);

    $book_data = array_shift($result);

    // var_dump($user_data);

    $conn = null;

  } catch(PDOException $e) {
    
  }

  $text = "Update Book";

  $title_field_label = "Title";
  $excerpt_field_label = "Excerpt";


?>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update Book</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link rel="stylesheet" href="css/styles.css">
  
</head>
<body>

  <!-- HEADER -->
  <header>
  </header>

  <!-- MAIN -->
  <main >
    <div class="container">
      <div class="row registration justify-content-center align-items-center">
        <div class="col-lg-4 mx-auto">
          <h2 class="text-center mb-3"><?php echo $text; ?></h2>
          <form method="post" action="<?php echo "{$url}/db/action/toupdatebooks.php"; ?>" id="register-form" enctype="multipart/form-data" novalidate>
            <input type="hidden" name="bookid" value="<?php echo $bookid; ?>">
            <div class="row">
              <div class="col border border-2 rounded rounded-3 p-5">
                <div class="mb-5">
                  <?php 

$servername = "localhost";
$username = "root";
$password = "";
$dbname= "Act9";

    $conn = new PDO("mysql:host=$servername;port=3306", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $sql = "use ". $dbname;
    $conn->exec($sql);
        $SELECT = "SELECT * FROM books WHERE id='$bookid'";
        $result2 = $conn->query($SELECT);
        $book_data1 = $result2->fetch(PDO::FETCH_ASSOC);
        ?>
                  <img id="uploadPreview" src="<?php echo $book_data1['image']; ?>" class="mb-3 avatar img-fluid"/><br>
                  <input type="file" id="imglink" name="imglink" accept=".jpg,.jpeg,.png" onchange="PreviewImage();"/>
                </div>
                <div class="mb-3">
                  <label for="login-email" class="form-label d-none"><?php echo $title_field_label; ?></label>
                  <input type="text" class="form-control" name="title" id="login-email" required="false" placeholder="<?php echo "Enter $title_field_label" ?>" value="<?php echo $book_data['title']; ?>">
                  <div id="login-email-msg" class="form-text"></div>
                </div>
                <div class="mb-3">
                  <label for="login-email" class="form-label d-none"><?php echo $excerpt_field_label; ?></label>
                  <input type="text" class="form-control" name="excerpt" id="login-email" required="false" placeholder="<?php echo "Enter $excerpt_field_label" ?>" value="<?php echo $book_data['excerpt']; ?>">
                  <div id="login-email-msg" class="form-text"></div> 
                </div>
      
                <div class="d-grid mt-5">
                  <button type="submit" name="submit" value="Register" id="form-submit" class="btn btn-primary">Update Book</button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>

  </main>

  <script type="text/javascript">

    function PreviewImage() {
        var oFReader = new FileReader();
        oFReader.readAsDataURL(document.getElementById("imglink").files[0]);

        oFReader.onload = function (oFREvent) {
            document.getElementById("uploadPreview").src = oFREvent.target.result;
        };
    };
	</script>

  <!-- FOOTER -->
  <footer>

  </footer>
  
  <!-- <script src="js/main.js"></script> -->

  <script>
    // var login_form = document.getElementById("login-form")
    // login_form.addEventListener("submit", function(event){
    //   event.preventDefault()
    // });
  </script>
</body>
</html>