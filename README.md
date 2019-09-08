# lifecycle

## Following is sequence of a bean lifecycle in Spring

* Instantiate: First the spring container finds the bean’s definition from the XML file/Annotation and instantiates the bean.
* Populate properties: Using the dependency injection, spring populates all of the properties as specified in the bean definition.
* Set Bean Name: If the bean implements ```BeanNameAware``` interface, spring passes the bean’s id to ```setBeanName()``` method.
* Set Bean factory: If Bean implements ```BeanFactoryAware``` interface, spring passes the ```beanfactory``` to ```setBeanFactory()``` method.
* Pre Initialization: Also called post process of bean. If there are any bean ```BeanPostProcessors``` associated with the bean, Spring calls ```postProcesserBeforeInitialization()``` method.
* Initialize beans: If the bean implements ```IntializingBean```,its ```afterPropertySet()``` method is called. If the bean has init method declaration, the specified initialization method is called.
* Post Initialization: – If there are any BeanPostProcessors associated with the bean, their ```postProcessAfterInitialization()``` methods will be called.
* Ready to use: Now the bean is ready to use by the application
* Destroy: If the bean implements ```DisposableBean``` , it will call the ```destroy()``` method
