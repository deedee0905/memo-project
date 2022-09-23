package com.amita.springProject.ex.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {

	public static final String FILE_UPLOAD_PATH = "C:\\Users\\남상우\\Desktop\\상아\\spring_project\\memo\\upload";
	
	// 파일을 저장하고, 해당 파일에 접근할 경로를 돌려주는 기능
	public static String saveFile(int userId, MultipartFile file) {
		
		// 서버에 저장할 위치를 잡아주기
		// 디렉토리를 생성(폴더)
		// 사용자 id + 현재 시간
		// UNIX TIME 활용하기 (파일이름_48965489696 이런식으로)
		// C:\\Users\\남상우\\Desktop\\상아\\spring_project\\memo\\upload\파일이름_48965489696\asdf.jpg
		
		String directoryName = "/" + userId + "_" + System.currentTimeMillis() + "/";
		
		// 디렉토리 생성
		String filePath = FILE_UPLOAD_PATH + directoryName;
		File directory =  new File(filePath);
		if(directory.mkdir() == false) {
			// 디렉토리 생성 실패
			return null;
		}
	
		try {
			byte[] bytes = file.getBytes();
			
			String fileFullPath = filePath + file.getOriginalFilename();
			Path path = Paths.get(fileFullPath);
			Files.write(path, bytes);
			
		} catch (IOException e) {
			e.printStackTrace();
			
			// 파일 저장 실패인 경우
			return null;
		}
		
		// 클라이언트에서 접근 가능한 경로 
		// C:\\Users\\남상우\\Desktop\\상아\\spring_project\\memo\\upload 해당 디렉토리 아래 경로
		// /images/~
		
		return "/images" + directoryName + file.getOriginalFilename();
		
		
	}
	
	// 파일 삭제 기능
	public static boolean removeFile(String filePath) {
		// 삭제 경로 /images 를 제거하고
		// 실제 파일 저장 경로를 이어 붙여주면 된다.
		
		if(filePath == null) {
			return true;
		}
		
		String realFilePath = FILE_UPLOAD_PATH + filePath.replace("/images", "");
		
		Path path = Paths.get(realFilePath);
		// 파일이 있는지 확인
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				
				e.printStackTrace();
				return false;
			}
		}
		
		path = path.getParent();
		
		
		// 디렉토리 존재하는지 여부 확인
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}
	
	
	
}
