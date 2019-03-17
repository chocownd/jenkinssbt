package basic.classloader;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * To test getResource method's working test
 *
 * @author hallofchoco@gmail.com
 * @since 16/03/2019
 */
@Slf4j
public class GetResourceTest {
    public static void main(String[] args) throws IOException {
        Class<GetResourceTest> klass = GetResourceTest.class;

        // getResource 메서드는 현재 클래스가 위치하고 있는 패키지를 루트로 하여 주어진 파일을 찾음
        // 이 때 컴파일 후 실행을 위해 배치된 바이트 코드(*.class) 기준의 경로임을 유의
        URL klassDotResource = klass.getResource(".");
        log.info("klassDotResource: file: {}, path: {}",
                 klassDotResource.getFile(),
                 klassDotResource.getPath());

        // 특별히 slash로 경로를 시작할 경우 classpath를 루트로 하여 찾음
        URL klassSlashResource = klass.getResource("/");
        log.info("klassSlashResource: file: {}, path: {}",
                 klassSlashResource.getFile(),
                 klassSlashResource.getPath());

        // 따라서 resources(classpath)/test/resource_test.test 파일을 찾고 싶으면,
        // /test/resource_test.test 처럼 classpath를 루트로 하도록 주던지,
        URL klassTestFileWithSlashResource = klass.getResource("/test/resource_test.test");
        log.info("klassTestFileWithSlashResource: file: {}, path: {}",
                 klassTestFileWithSlashResource.getFile(),
                 klassTestFileWithSlashResource.getPath());

        // ../../test/resource_test.txt 처럼 상대경로로 클래스 패스 루트까지 올라가도록 해 줘야함
        URL klassTestFileWithDotResource = klass.getResource("../../test/resource_test.test");
        log.info("klassTestFileWithDotResource: file: {}, path: {}",
                 klassTestFileWithDotResource.getFile(),
                 klassTestFileWithDotResource.getPath());



        System.out.println("----");


        ClassLoader classLoader = klass.getClassLoader();
        // 현재 클래스의 위치와는 무관하게 classpath의 모든 루트를 기준으로 찾음
        Enumeration<URL> classLoaderDotResources = classLoader.getResources(".");
        while (classLoaderDotResources.hasMoreElements()) {
            URL classLoaderDotResource = classLoaderDotResources.nextElement();
            log.info("classLoaderDotResources: file: {}, path: {}",
                     classLoaderDotResource.getFile(),
                     classLoaderDotResource.getPath());
        }
        // slash로 시작할 수는 없음(아무 리소스도 찾지 못함)
        Enumeration<URL> classLoaderSlashResources =
            classLoader.getResources("/");
        while (classLoaderSlashResources.hasMoreElements()) {
            URL classLoaderSlashResource =
                classLoaderSlashResources.nextElement();
            log.info("classLoaderSlashResources: file: {}, path: {}",
                     classLoaderSlashResource.getFile(),
                     classLoaderSlashResource.getPath());
        }
        // 상대경로에서도 적용되지 않음(아무 리소스도 찾지 못함)
        Enumeration<URL> classLoaderRelativeResources =
            classLoader.getResources("../../");
        while (classLoaderRelativeResources.hasMoreElements()) {
            URL classLoaderRelativeResource =
                classLoaderRelativeResources.nextElement();
            log.info("classLoaderRelativeResources: file: {}, path: {}",
                     classLoaderRelativeResource.getFile(),
                     classLoaderRelativeResource.getPath());
        }
        // classpath를 recursive하게 찾는 건 아님
        Enumeration<URL> classLoaderTestfileResources =
            classLoader.getResources("resource_test.test");
        while (classLoaderTestfileResources.hasMoreElements()) {
            URL classLoaderTestfileResource =
                classLoaderTestfileResources.nextElement();
            log.info("classLoaderTestfileResources: file: {}, path: {}",
                     classLoaderTestfileResource.getFile(),
                     classLoaderTestfileResource.getPath());
        }

    }
}
