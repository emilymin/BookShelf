<!DOCTYPE html>
<html>
	<head>
		<title>BookShelf</title>
		<link rel="stylesheet" href="css/index.css">
	</head>
	<body>
	<img src=""
		<div class="nav-wrapper">
			<div class="nav-primary">
				<div class="nav-logo">BOOKSHELF</div>
				<form action="ShowBook" method="post">
                                <input type="submit" value="show books"/>
                            </form>
				<div class="nav-search">
					<form action="QueryBook" method="post">
						<div class="inp">
							<input id="inp-query" size="22" type="text" placeholder="书名" name="bookName">
						</div>
						<div class="inp-btn">
							<input id="inp-sub" type="submit" value="search">
						</div>
					</form>
					<form action="BorrowBook" method="post">
                                    <input type="text" name="borrowISBN" />
                                    <input type="submit" value="borrow" />
                                </form>
				</div>
			</div>
		</div>
		<div id="slide-left">
			<div class="book-add-list">
				<div class="book-add-header">ADD BOOK</div>
				<div class="book-add-content">
					<form action="BookShelf" method="post">
						<div class="book-attribute" style="margin-top:15px">
							<div class="inp-name">TYPE</div>
							<div class="inp-content">
								<select class="book-input" name="type">
                                    <option value ="ELECTRONIC">ELECTRONIC</option>
                                    <option value ="PHYSICAL">PHYSICAL</option>
                                </select>
							</div>
						</div>
						<div class="book-attribute">
							<div class="inp-name">ISBN</div>
							<div class="inp-content">
								<input  class="book-input" type="text" name="isbn">
							</div>
						</div>
						<div class="book-attribute">
							<div class="inp-name">NAME</div>
							<div class="inp-content">
								<input  class="book-input" type="text" name="name">
							</div>
						</div>
						<div class="book-attribute">
							<div class="inp-name">AUTHOR</div>
							<div class="inp-content">
								<input  class="book-input" type="text" name="author">
							</div>
						</div>
						<div class="book-attribute">
							<div class="inp-name">LOCATION</div>
							<div class="inp-content">
								<input  class="book-input" type="text" name="location">
							</div>
						</div>
						<div class="book-btn">
							<input id="btn-add-book" type="submit" value="ADD">
						</div>
					</form>
				</div>
			</div>

		</div>
		<div id="content"> 
			<div class="book-express"> 
				 <div class="hd">
				 	<h2 class>
				 		<span class>我的书架</span>
				 		<span class="link-more">
				 			<a class href="">更多》</a>
				 		</span>
				 	</h2>
				 	<div class="slide-controls">
				 		<ol class="slide-dots">
				 			<li class="dots">
				 				<a data-index="1" href="#" class="active"></a>
				 			</li>
				 			<li class="dots">
				 				<a data-index="2" href="#" class="active"></a>
				 			</li>
				 			<li class="dots">
				 				<a data-index="3" href="#" class="active"></a>
				 			</li>
				 			<li class="dots">
				 				<a data-index="4" href="#" class="active"></a>
				 			</li>
				 		</ol>
				 		<div class="slide-btns">
				 			<a href="#" class="prev">‹</a>
				 			<a href="#" class="next">›</a>
				 		</div>			 		
				 	</div>
				 </div>

				 <div class="bd">
				 	<div class="carousel">
				 		<div class="slide-list" style="width: 590px; left: -590px;"> 
				 			<ul class="slide-item">
				 				<li class>
				 					<div class="cover">
				 						<a href="http://book.douban.com/subject/25918073/?icn=index-latestbook-subject" title="独眼少女">
				 							<img src="http://img3.douban.com/lpic/s27355360.jpg" class width="106px" height="158px" alt="独眼少女">
				 						</a>
				 					</div>
				 					<div class="info">
				 						<div div class="title">
				 							<a class href="http://book.douban.com/subject/25918073/?icn=index-latestbook-subject" title="独眼少女">独眼少女</a>
				 						</div>
				 						<div class="author">（日）麻耶雄嵩</div>
				 					</div>
				 				</li>
				 				<li class>
				 					<div class="cover">
				 						<a href="http://book.douban.com/subject/25931205/?icn=index-latestbook-subject" title="雨中百合般的爱情">
	                						<img src="http://img3.douban.com/lpic/s27354585.jpg" class="" width="106px" height="158px" alt="雨中百合般的爱情">
	              						</a> 
				 					</div>
				 					<div class="info">
							          <div class="title">
							            <a class="" href="http://book.douban.com/subject/25931205/?icn=index-latestbook-subject" title="雨中百合般的爱情">雨中百合般的爱情</a>
							          </div>
							          <div class="author">苏七七</div>      
							        </div>		 
				 				</li>
				 				<li class="">
						            <div class="cover">
						              <a href="http://book.douban.com/subject/25947743/?icn=index-latestbook-subject" title="少女的港湾">
						                <img src="http://img5.douban.com/lpic/s27377526.jpg" class="" width="106px" height="158px" alt="少女的港湾">
						              </a>
						            </div>
						            <div class="info">
						              <div class="title">
						                <a class="" href="http://book.douban.com/subject/25947743/?icn=index-latestbook-subject" title="少女的港湾">少女的港湾</a>
						              </div>
						              <div class="author">[日]川端康成</div>
						            </div>
						         </li>
				 				<li class="">
						            <div class="cover">
						              <a href="http://book.douban.com/subject/25938970/?icn=index-latestbook-subject" title="现在的泪，都是当年脑子进的水">
						                <img src="http://img5.douban.com/lpic/s27349708.jpg" class="" width="106px" height="158px" alt="现在的泪，都是当年脑子进的水">
						              </a>
						            </div>
						            <div class="info">
						              <div class="title">
						                <a class="" href="http://book.douban.com/subject/25938970/?icn=index-latestbook-subject" title="现在的泪，都是当年脑子进的水">现在的泪，都是当年脑子进的水</a>
						              </div>
						              <div class="author">马华兴</div>
						            </div>
						         </li>
				 				<li class="">
						            <div class="cover">
						              <a href="http://book.douban.com/subject/25871642/?icn=index-latestbook-subject" title="春花的葬礼">
						                <img src="http://img3.douban.com/lpic/s27282225.jpg" class="" width="106px" height="158px" alt="春花的葬礼">
						              </a>
						            </div>
						            <div class="info">
						              <div class="title">
						                <a class="" href="http://book.douban.com/subject/25871642/?icn=index-latestbook-subject" title="春花的葬礼">春花的葬礼</a>
						              </div>
						              <div class="author">[法] 弗朗西斯·耶麦</div>					               
						            </div>
						         </li>
				 				<li class="">
						            <div class="cover">
						              <a href="http://book.douban.com/subject/25875954/?icn=index-latestbook-subject" title="论邪恶">
						                <img src="http://img5.douban.com/lpic/s27318848.jpg" class="" width="106px" height="158px" alt="论邪恶">
						              </a>
						            </div>
						            <div class="info">
						              <div class="title">
						                <a class="" href="http://book.douban.com/subject/25875954/?icn=index-latestbook-subject" title="论邪恶">论邪恶</a>
						              </div>
						              <div class="author">[英] 特里·伊格尔顿</div>              
						            </div>
						         </li>
				 				<li class="">
						            <div class="cover">
						              <a href="http://book.douban.com/subject/25951036/?icn=index-latestbook-subject" title="星笼之海">
						                <img src="http://img5.douban.com/lpic/s27401077.jpg" class="" width="106px" height="158px" alt="星笼之海">
						              </a>
						            </div>
						            <div class="info">
						              <div class="title">
						                <a class="" href="http://book.douban.com/subject/25951036/?icn=index-latestbook-subject" title="星笼之海">星笼之海</a>
						              </div>
						              <div class="author">(日)岛田庄司</div>				               
						        </li>
				 				<li class="">
						            <div class="cover">
						              <a href="http://book.douban.com/subject/25937939/?icn=index-latestbook-subject" title="一个人也能有很好的时候">
						                <img src="http://img3.douban.com/lpic/s27349173.jpg" class="" width="106px" height="158px" alt="一个人也能有很好的时候">
						              </a>
						            </div>
						            <div class="info">
						              <div class="title">
						                <a class="" href="http://book.douban.com/subject/25937939/?icn=index-latestbook-subject" title="一个人也能有很好的时候">一个人也能有很好的时候</a>
						              </div>
						              <div class="author">艾莉</div>				               
						            </div>
	          					</li>
				 				<li class="">
						            <div class="cover">
						              <a href="http://book.douban.com/subject/25913219/?icn=index-latestbook-subject" title="孤独的精确度">
						                <img src="http://img3.douban.com/lpic/s27311252.jpg" class="" width="106px" height="158px" alt="孤独的精确度">
						              </a>
						            </div>
						            <div class="info">
						              <div class="title">
						                <a class="" href="http://book.douban.com/subject/25913219/?icn=index-latestbook-subject" title="孤独的精确度">孤独的精确度</a>
						              </div>
						              <div class="author">[挪威]尤·奈斯博</div>               
						            </div>
						        </li>
				 				<li class="">
						            <div class="cover">
						              <a href="http://book.douban.com/subject/25905654/?icn=index-latestbook-subject" title="山河小岁月">
						                <img src="http://img3.douban.com/lpic/s27338950.jpg" class="" width="106px" height="158px" alt="山河小岁月">
						              </a>
						            </div>
						            <div class="info">
						              <div class="title">
						                <a class="" href="http://book.douban.com/subject/25905654/?icn=index-latestbook-subject" title="山河小岁月">山河小岁月</a>
						              </div>
						              <div class="author">李舒</div>					               
						            </div>
						         </li>
				 			</ul> 
				 		</div>
				 	</div>
				 </div>
			</div>
		</div>
	</body>
</html>
